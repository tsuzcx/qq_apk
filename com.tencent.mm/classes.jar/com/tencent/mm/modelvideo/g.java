package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.k.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class g
{
  public static final long oYh;
  Context context;
  int duration;
  String fileName;
  Intent intent;
  public g.a oYi;
  String oYj;
  String oYk;
  String oYl;
  String oYm;
  final AsyncTask<String, Integer, String> oYn;
  String thumbPath;
  String videoPath;
  
  static
  {
    AppMethodBeat.i(126785);
    oYh = c.aRj();
    AppMethodBeat.o(126785);
  }
  
  public g()
  {
    AppMethodBeat.i(126783);
    this.context = null;
    this.oYi = null;
    this.oYj = null;
    this.duration = 0;
    this.intent = null;
    this.fileName = null;
    this.thumbPath = null;
    this.videoPath = null;
    this.oYk = null;
    this.oYl = null;
    this.oYm = null;
    this.oYn = new AsyncTask()
    {
      int ret = 0;
      
      private String bNP()
      {
        AppMethodBeat.i(126780);
        this.ret = 0;
        boolean bool = NetStatusUtil.is2G(MMApplicationContext.getContext());
        Object localObject;
        try
        {
          a.a locala = a.j(g.this.context, g.this.intent);
          if (locala == null)
          {
            Log.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
            h.OAn.idkeyStat(106L, 244L, 1L, false);
            this.ret = -50005;
            AppMethodBeat.o(126780);
            return null;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.ImportVideo", "exception:%s", new Object[] { Util.stackTraceToString(localException1) });
            localObject = null;
          }
          g.this.oYj = localObject.filename;
          i = (int)y.bEl(g.this.oYj);
          Log.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localObject.duration), g.this.oYj });
          if (i <= 0)
          {
            h.OAn.idkeyStat(106L, 244L, 1L, false);
            this.ret = -50001;
            AppMethodBeat.o(126780);
            return null;
          }
          long l2 = i;
          if (bool) {}
          for (long l1 = 10485760L; l2 > l1; l1 = g.oYh)
          {
            h.OAn.idkeyStat(106L, 245L, 1L, false);
            this.ret = -50002;
            AppMethodBeat.o(126780);
            return null;
          }
          y.O(g.this.oYj, g.this.videoPath, false);
          if (TextUtils.isEmpty(g.this.oYk)) {
            break label576;
          }
        }
        int j = 1;
        if (j != 0) {
          y.O(g.this.oYj, g.this.oYm, false);
        }
        g.this.duration = (localObject.duration / 1000);
        int k = 1;
        i = 1;
        if (localObject.bitmap != null) {}
        for (;;)
        {
          try
          {
            BitmapUtil.saveBitmapToImage(localObject.bitmap, 60, Bitmap.CompressFormat.JPEG, g.this.thumbPath, true);
            if (j != 0) {
              BitmapUtil.saveBitmapToImage(localObject.bitmap, 60, Bitmap.CompressFormat.JPEG, g.this.oYl, true);
            }
          }
          catch (Exception localException2)
          {
            label576:
            i = k;
          }
          for (;;)
          {
            try
            {
              h.OAn.idkeyStat(106L, 231L, 1L, false);
              i = 0;
              if (i == 0) {
                break;
              }
            }
            catch (Exception localException4)
            {
              i = 0;
              continue;
            }
            try
            {
              h.OAn.idkeyStat(106L, 232L, 1L, false);
              BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, g.this.thumbPath, true);
              if (j != 0) {
                BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, g.this.oYl, true);
              }
            }
            catch (Exception localException3)
            {
              Log.e("MicroMsg.ImportVideo", "exception:%s", new Object[] { Util.stackTraceToString(localException3) });
              break;
            }
          }
          if (!y.ZC(g.this.videoPath)) {
            this.ret = -50003;
          }
          if (!y.ZC(g.this.thumbPath)) {
            this.ret = -50004;
          }
          if (j != 0)
          {
            if (!y.ZC(g.this.oYm)) {
              this.ret = -50003;
            }
            if (!y.ZC(g.this.oYl)) {
              this.ret = -50004;
            }
          }
          AppMethodBeat.o(126780);
          return null;
          j = 0;
          break;
          Log.e("MicroMsg.ImportVideo", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
        }
      }
    };
    AppMethodBeat.o(126783);
  }
  
  public final void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(241291);
    this.context = paramContext;
    this.intent = paramIntent;
    this.fileName = aa.PW(paramString);
    v.bOh();
    this.thumbPath = aa.PY(this.fileName);
    v.bOh();
    this.videoPath = aa.PX(this.fileName);
    if (paramBoolean)
    {
      this.oYk = (this.fileName + "origin");
      v.bOh();
      this.oYl = aa.PY(this.oYk);
      v.bOh();
      this.oYm = aa.PX(this.oYk);
    }
    this.oYi = parama;
    this.oYn.execute(new String[0]);
    AppMethodBeat.o(241291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */