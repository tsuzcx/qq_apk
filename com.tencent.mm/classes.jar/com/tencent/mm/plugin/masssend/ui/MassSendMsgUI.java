package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MassSendMsgUI
  extends MMActivity
  implements i
{
  private static String zok = "";
  private String filePath;
  private List<String> gxh;
  private TextView hXK;
  private com.tencent.mm.ui.base.q tipDialog;
  private ChatFooter znD;
  private String znF;
  private boolean znG;
  private TextView zoj;
  private com.tencent.mm.ui.widget.a.d zol;
  private b zom;
  private AppPanel.a zon;
  
  public MassSendMsgUI()
  {
    AppMethodBeat.i(26474);
    this.tipDialog = null;
    this.znG = false;
    this.zon = new AppPanel.a()
    {
      public final void Qj(int paramAnonymousInt)
      {
        AppMethodBeat.i(26463);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(26463);
          return;
          com.tencent.mm.pluginsdk.ui.tools.s.a(MassSendMsgUI.this, 1, 1, 3, 3, null);
          AppMethodBeat.o(26463);
          return;
          com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKV());
          if ((!localo.exists()) && (!localo.mkdirs()))
          {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131757534), 1).show();
            AppMethodBeat.o(26463);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
          Log.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), MassSendMsgUI.this.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(26463);
            return;
          }
          MassSendMsgUI.c(MassSendMsgUI.this);
        }
      }
      
      public final void Qk(int paramAnonymousInt)
      {
        AppMethodBeat.i(26467);
        MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousInt);
        AppMethodBeat.o(26467);
      }
      
      public final void d(g paramAnonymousg) {}
      
      public final void ehU()
      {
        AppMethodBeat.i(26458);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762975), 0).show();
        AppMethodBeat.o(26458);
      }
      
      public final void ehV()
      {
        AppMethodBeat.i(26459);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762957), 0).show();
        AppMethodBeat.o(26459);
      }
      
      public final void ehW()
      {
        AppMethodBeat.i(26460);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762973), 0).show();
        AppMethodBeat.o(26460);
      }
      
      public final void ehX()
      {
        AppMethodBeat.i(26461);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762966), 0).show();
        AppMethodBeat.o(26461);
      }
      
      public final void ehY()
      {
        AppMethodBeat.i(26462);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762957), 0).show();
        AppMethodBeat.o(26462);
      }
      
      public final void ehZ()
      {
        AppMethodBeat.i(26464);
        com.tencent.mm.plugin.masssend.a.jRt.cb(MassSendMsgUI.this);
        AppMethodBeat.o(26464);
      }
      
      public final void eia()
      {
        AppMethodBeat.i(26465);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762957), 0).show();
        AppMethodBeat.o(26465);
      }
      
      public final void eib() {}
      
      public final void eic()
      {
        AppMethodBeat.i(26466);
        Intent localIntent = new Intent();
        localIntent.putExtra("preceding_scence", 13);
        com.tencent.mm.br.c.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
        AppMethodBeat.o(26466);
      }
      
      public final void eid()
      {
        AppMethodBeat.i(26468);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131762967), 0).show();
        AppMethodBeat.o(26468);
      }
      
      public final void eie() {}
      
      public final void eif() {}
      
      public final void eig() {}
      
      public final void eih() {}
      
      public final void eii() {}
      
      public final void eij() {}
      
      public final void eik() {}
      
      public final void eil() {}
    };
    AppMethodBeat.o(26474);
  }
  
  public static void aDR(String paramString)
  {
    zok = paramString;
  }
  
  private static void aDS(String paramString)
  {
    AppMethodBeat.i(26491);
    long l = com.tencent.mm.vfs.s.boW(paramString);
    int i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, 247, 255));
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 246L, 1L, false);
    Log.d("MicroMsg.MassSendMsgUI", "report video size res : " + i + " hadCompress : true fileLen : " + l / 1024L + "K");
    AppMethodBeat.o(26491);
  }
  
  private void aI(Intent paramIntent)
  {
    AppMethodBeat.i(26483);
    Object localObject = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    paramIntent = new com.tencent.mm.plugin.masssend.a.a();
    paramIntent.znm = this.znF;
    paramIntent.znn = this.gxh.size();
    paramIntent.filename = ((String)localObject);
    paramIntent.zno = i;
    paramIntent.msgType = 43;
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.znG);
    bg.azz().a(paramIntent, 0);
    localObject = getContext();
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131765237), true, new MassSendMsgUI.12(this, paramIntent));
    AppMethodBeat.o(26483);
  }
  
  private void aJ(Intent paramIntent)
  {
    AppMethodBeat.i(26484);
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null)
    {
      AppMethodBeat.o(26484);
      return;
    }
    if (z.f((String)localObject, null, paramIntent.getBooleanExtra("CropImage_Compress_Img", true))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.masssend.a.h.ehF();
      paramIntent = com.tencent.mm.plugin.masssend.a.b.l((String)localObject, this.znF, this.gxh.size(), i);
      if (paramIntent != null) {
        break;
      }
      AppMethodBeat.o(26484);
      return;
    }
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.znG, i);
    bg.azz().a(paramIntent, 0);
    localObject = getContext();
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131765237), true, new MassSendMsgUI.13(this, paramIntent));
    AppMethodBeat.o(26484);
  }
  
  private void aK(final Intent paramIntent)
  {
    AppMethodBeat.i(26487);
    if (!ag.dm(this))
    {
      com.tencent.mm.ui.base.h.a(this, 2131767069, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26449);
          MassSendMsgUI.b(MassSendMsgUI.this, paramIntent);
          AppMethodBeat.o(26449);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(26487);
      return;
    }
    aL(paramIntent);
    AppMethodBeat.o(26487);
  }
  
  private void aL(Intent paramIntent)
  {
    AppMethodBeat.i(26488);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.jpO = null;
      }
    });
    localc.a(this, paramIntent, this.znF, new c.a()
    {
      public final void c(int paramAnonymousInt1, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(26453);
        Log.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2 });
        if ((paramAnonymousInt1 < 0) && (paramAnonymousInt1 != -50002))
        {
          Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131767067), 0).show();
          if (MassSendMsgUI.d(MassSendMsgUI.this) != null)
          {
            MassSendMsgUI.d(MassSendMsgUI.this).dismiss();
            MassSendMsgUI.e(MassSendMsgUI.this);
            AppMethodBeat.o(26453);
          }
        }
        else
        {
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26452);
              if (MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousString1, paramAnonymousString2))
              {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(26450);
                    MassSendMsgUI.a(MassSendMsgUI.this, MassSendMsgUI.6.1.this.val$fileName, MassSendMsgUI.6.1.this.moi);
                    AppMethodBeat.o(26450);
                  }
                });
                AppMethodBeat.o(26452);
                return;
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26451);
                  Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131767068), 0).show();
                  if (MassSendMsgUI.d(MassSendMsgUI.this) != null)
                  {
                    MassSendMsgUI.d(MassSendMsgUI.this).dismiss();
                    MassSendMsgUI.e(MassSendMsgUI.this);
                  }
                  AppMethodBeat.o(26451);
                }
              });
              AppMethodBeat.o(26452);
            }
          }, "MassSend_Remux");
        }
        AppMethodBeat.o(26453);
      }
    });
    AppMethodBeat.o(26488);
  }
  
  private void dRW()
  {
    AppMethodBeat.i(26481);
    if (!com.tencent.mm.pluginsdk.ui.tools.s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131765171), 1).show();
    }
    AppMethodBeat.o(26481);
  }
  
  private void ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(26486);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.jpO = null;
      }
    });
    ThreadPool.post(new MassSendMsgUI.2(this, paramString, paramInt), "MassSend_Remux");
    AppMethodBeat.o(26486);
  }
  
  private boolean iE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26489);
    boolean bool = NetStatusUtil.is2G(this);
    int i;
    if (bool)
    {
      i = 10485760;
      label22:
      if (!bool) {
        break label148;
      }
    }
    label148:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      i = SightVideoJNI.shouldRemuxingVFS(paramString2, 660, 500, i, d, 1000000);
      Log.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(26489);
        return false;
        i = 26214400;
        break label22;
      }
    }
    com.tencent.mm.modelvideo.o.bhj();
    aDS(com.tencent.mm.modelvideo.t.Qw(paramString1));
    AppMethodBeat.o(26489);
    return true;
    AppMethodBeat.o(26489);
    return false;
    com.tencent.mm.modelvideo.o.bhj();
    String str = com.tencent.mm.modelvideo.t.Qw(paramString1);
    com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
    locald.setDataSource(paramString2);
    Log.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[] { str });
    int m = Util.getInt(locald.extractMetadata(18), 0);
    int n = Util.getInt(locald.extractMetadata(19), 0);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    Object localObject = new PInt();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    PInt localPInt3 = new PInt();
    PInt localPInt4 = new PInt();
    com.tencent.mm.plugin.sight.base.e.a(paramString2, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
    localVideoTransPara.duration = (((PInt)localObject).value / 1000);
    localVideoTransPara.width = localPInt1.value;
    localVideoTransPara.height = localPInt2.value;
    localVideoTransPara.fps = localPInt3.value;
    localVideoTransPara.videoBitrate = localPInt4.value;
    localObject = com.tencent.mm.modelcontrol.e.baZ().c(localVideoTransPara);
    int i2 = com.tencent.mm.plugin.sight.base.c.Dmd;
    Log.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", new Object[] { localVideoTransPara, localObject });
    int i1;
    int j;
    int k;
    if (localObject == null)
    {
      i1 = 0;
      i = n;
      j = m;
      if (i1 < 3)
      {
        k = j;
        if (j % 2 != 0) {
          k = j - 1;
        }
        j = i;
        if (i % 2 != 0) {
          j = i - 1;
        }
        if (((k >= j) && ((k <= 640) || (j <= 480))) || ((k <= j) && ((k <= 480) || (j <= 640))))
        {
          i = k;
          k = i2;
        }
      }
    }
    for (;;)
    {
      locald.release();
      k = SightVideoJNI.remuxingVFS(paramString2, str, i, j, k, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.Dme, null, 0, false, 0, 51);
      if (k >= 0) {
        break label646;
      }
      Log.w("MicroMsg.MassSendMsgUI", "remuxing video error");
      AppMethodBeat.o(26489);
      return false;
      i = k / 2;
      k = j / 2;
      i1 += 1;
      j = i;
      i = k;
      break;
      j = n;
      i = m;
      k = i2;
      continue;
      i = ((VideoTransPara)localObject).width;
      j = ((VideoTransPara)localObject).height;
      k = ((VideoTransPara)localObject).videoBitrate;
    }
    label646:
    aDS(str);
    com.tencent.mm.modelvideo.o.bhj();
    paramString1 = com.tencent.mm.modelvideo.t.Qx(paramString1);
    if (!com.tencent.mm.vfs.s.YS(paramString1)) {
      Log.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[] { paramString1 });
    }
    try
    {
      paramString2 = BitmapUtil.createVideoThumbnail(str, 1);
      if (paramString2 != null) {
        BitmapUtil.saveBitmapToImage(paramString2, 60, Bitmap.CompressFormat.JPEG, paramString1, true);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MassSendMsgUI", paramString1, "", new Object[0]);
        Log.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[] { paramString1.getMessage() });
      }
    }
    Log.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    AppMethodBeat.o(26489);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131495469;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(26479);
    setMMTitle(2131762968);
    this.zoj = ((TextView)findViewById(2131304529));
    this.hXK = ((TextView)findViewById(2131304528));
    TextView localTextView = this.zoj;
    int j = (int)this.zoj.getTextSize();
    Object localObject;
    int i;
    if (this.gxh == null)
    {
      localObject = new SpannableString("");
      localTextView.setText((CharSequence)localObject);
      this.hXK.setText(getResources().getQuantityString(2131623956, this.gxh.size(), new Object[] { Integer.valueOf(this.gxh.size()) }));
      this.znD = ((ChatFooter)findViewById(2131305225));
      ((MassSendLayout)findViewById(2131304533)).setPanel(this.znD.getPanel());
      this.znD.setCattingRootLayoutId(2131304533);
      this.zom = new b(this, this.znD, this.znF, this.gxh, this.znG);
      this.znD.setFooterEventListener(this.zom);
      localObject = new d(this);
      this.znD.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject);
      localObject = this.znD;
      bg.aVF();
      j = ((Integer)com.tencent.mm.model.c.azQ().get(18, Integer.valueOf(-1))).intValue();
      i = j;
      if (j == -1) {
        i = 1;
      }
      ((ChatFooter)localObject).setMode(i);
      this.znD.setUserName("masssendapp");
      this.znD.Kik.refresh();
      this.znD.Kik.gpS();
      this.znD.Kik.gpT();
      this.znD.Kik.gpU();
      bg.aVF();
      if (((Boolean)com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue())
      {
        this.znD.gqF();
        this.znD.gql();
      }
      this.znD.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(26457);
          paramAnonymousCharSequence = String.valueOf(paramAnonymousCharSequence);
          final String str = paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3);
          if (((MassSendMsgUI.a(MassSendMsgUI.this) == null) || (!MassSendMsgUI.a(MassSendMsgUI.this).isShowing())) && (ImgUtil.isImgFile(str)))
          {
            Bitmap localBitmap = BitmapUtil.extractThumbNail(str, 300, 300, false);
            if (localBitmap == null)
            {
              Log.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
              AppMethodBeat.o(26457);
              return;
            }
            ImageView localImageView = new ImageView(MassSendMsgUI.this);
            localImageView.setImageBitmap(localBitmap);
            paramAnonymousInt2 = MassSendMsgUI.this.getResources().getDimensionPixelSize(2131165498);
            localImageView.setPadding(paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2);
            MassSendMsgUI.a(MassSendMsgUI.this, com.tencent.mm.ui.base.h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131757524), localImageView, MassSendMsgUI.this.getString(2131755921), MassSendMsgUI.this.getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(26456);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("CropImage_OutputPath", str);
                MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymous2DialogInterface);
                AppMethodBeat.o(26456);
              }
            }, null));
            paramAnonymousCharSequence = paramAnonymousCharSequence.substring(0, paramAnonymousInt1) + paramAnonymousCharSequence.substring(paramAnonymousInt1 + paramAnonymousInt3);
            MassSendMsgUI.b(MassSendMsgUI.this).z(paramAnonymousCharSequence, -1, false);
            MassSendMsgUI.aAn(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(26457);
        }
      });
      this.znD.Kik.gpP();
      this.znD.Kik.gpM();
      this.znD.Kik.gpO();
      this.znD.aX(true, true);
      this.znD.gqB();
      this.znD.zY(true);
      this.znD.setAppPanelListener(this.zon);
      localObject = this.znD;
      com.tencent.mm.br.c.gsX();
      if (!com.tencent.mm.aw.b.bdC()) {
        break label621;
      }
    }
    for (;;)
    {
      ((ChatFooter)localObject).zZ(bool);
      this.znD.Kik.gpQ();
      this.znD.Kik.gpR();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26446);
          MassSendMsgUI.this.finish();
          AppMethodBeat.o(26446);
          return true;
        }
      });
      AppMethodBeat.o(26479);
      return;
      localObject = new StringBuilder();
      i = 0;
      if (i < this.gxh.size())
      {
        String str = aa.getDisplayName((String)this.gxh.get(i));
        if (i == this.gxh.size() - 1) {
          ((StringBuilder)localObject).append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(str + ",  ");
        }
      }
      localObject = com.tencent.mm.pluginsdk.ui.span.l.e(this, ((StringBuilder)localObject).toString(), j);
      break;
      label621:
      bool = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26485);
    Log.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(26485);
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (paramInt1)
    {
    case 3: 
    default: 
      Log.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(26485);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(26485);
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject1 != null) && (((List)localObject1).size() == 1)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramIntent = (String)((List)localObject1).get(0);
        localObject1 = new Intent();
        ((Intent)localObject1).setData(Uri.parse("file://".concat(String.valueOf(paramIntent))));
        aK((Intent)localObject1);
        AppMethodBeat.o(26485);
        return;
      }
      localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        AppMethodBeat.o(26485);
        return;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)((List)localObject1).get(0));
      ((Intent)localObject2).putExtra("CropImage_Compress_Img", paramIntent.getBooleanExtra("CropImage_Compress_Img", true));
      aJ((Intent)localObject2);
      AppMethodBeat.o(26485);
      return;
    case 2: 
      localObject1 = getApplicationContext();
      bg.aVF();
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.aSY());
      if (this.filePath == null)
      {
        AppMethodBeat.o(26485);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 4);
      paramIntent.putExtra("CropImage_Filter", true);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.masssend.a.jRt.a(getContext(), paramIntent, 4);
      AppMethodBeat.o(26485);
      return;
    case 4: 
      aJ(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 9: 
      localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
      paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
      if (localObject1 != null)
      {
        if (((CaptureDataManager.CaptureVideoNormalModel)localObject1).BOe.booleanValue())
        {
          paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
          if (!Util.isNullOrNil(paramIntent)) {
            try
            {
              Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.ehF();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.l(paramIntent, this.znF, this.gxh.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.znG, 0);
              bg.azz().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131755998);
              this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(2131765237), true, new MassSendMsgUI.14(this, paramIntent));
              AppMethodBeat.o(26485);
              return;
            }
            catch (Exception paramIntent)
            {
              Log.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(26485);
          return;
        }
        Log.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath });
        paramIntent = com.tencent.mm.vfs.s.bpb(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
        com.tencent.mm.modelvideo.o.bhj();
        localObject2 = com.tencent.mm.modelvideo.t.Qw(paramIntent);
        if (!((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath.equals(localObject2))
        {
          Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, localObject2 });
          com.tencent.mm.vfs.s.nx(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, (String)localObject2);
        }
        ev(paramIntent, (int)(((CaptureDataManager.CaptureVideoNormalModel)localObject1).BOd.longValue() / 1000L));
      }
      AppMethodBeat.o(26485);
      return;
    case 8: 
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent != null)
      {
        if (paramIntent.zsy)
        {
          paramIntent = paramIntent.zsG;
          if (!Util.isNullOrNil(paramIntent)) {
            try
            {
              Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.ehF();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.l(paramIntent, this.znF, this.gxh.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.znG, 0);
              bg.azz().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131755998);
              this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(2131765237), true, new MassSendMsgUI.15(this, paramIntent));
              AppMethodBeat.o(26485);
              return;
            }
            catch (Exception paramIntent)
            {
              Log.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(26485);
          return;
        }
        Log.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { paramIntent.zsA, paramIntent.zsB });
        com.tencent.mm.modelvideo.o.bhj();
        localObject1 = com.tencent.mm.modelvideo.t.Qw(paramIntent.zsC);
        if (!paramIntent.zsA.equals(localObject1))
        {
          Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { paramIntent.zsA, localObject1 });
          com.tencent.mm.vfs.s.nx(paramIntent.zsA, (String)localObject1);
        }
        ev(paramIntent.zsC, paramIntent.zsE);
      }
      AppMethodBeat.o(26485);
      return;
    case 7: 
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          aI(paramIntent);
          AppMethodBeat.o(26485);
          return;
        }
        aK(paramIntent);
        AppMethodBeat.o(26485);
        return;
      }
      break;
    case 5: 
      aI(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 6: 
      aK(paramIntent);
      AppMethodBeat.o(26485);
      return;
    }
    AppMethodBeat.o(26485);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26475);
    super.onCreate(paramBundle);
    bg.azz().a(193, this);
    this.znG = getIntent().getBooleanExtra("mass_send_again", false);
    this.znF = getIntent().getStringExtra("mass_send_contact_list");
    paramBundle = this.znF;
    this.gxh = new ArrayList();
    if ((paramBundle == null) || (paramBundle.equals(""))) {}
    for (;;)
    {
      initView();
      AppMethodBeat.o(26475);
      return;
      paramBundle = paramBundle.split(";");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.gxh = Util.stringsToList(paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26477);
    bg.azz().b(193, this);
    super.onDestroy();
    if (this.znD != null) {
      this.znD.destroy();
    }
    AppMethodBeat.o(26477);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26480);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.znD.gqJ()))
    {
      this.znD.setBottomPanelVisibility(8);
      AppMethodBeat.o(26480);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26480);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26478);
    this.znD.a(ChatFooter.h.Kmx);
    this.znD.onPause();
    super.onPause();
    AppMethodBeat.o(26478);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26482);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(26482);
      return;
    }
    Log.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26482);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dRW();
        AppMethodBeat.o(26482);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131756929), false, new MassSendMsgUI.11(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26476);
    super.onResume();
    if (this.znD != null)
    {
      this.znD.setLastText(zok);
      this.znD.a(getContext(), this);
    }
    AppMethodBeat.o(26476);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(26490);
    Log.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.zom != null)
    {
      b localb = this.zom;
      if (localb.tipDialog != null)
      {
        localb.tipDialog.dismiss();
        localb.tipDialog = null;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      zok = "";
      paramString = new Intent(this, MassSendHistoryUI.class);
      paramString.addFlags(67108864);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24))
    {
      Log.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
      Toast.makeText(this, 2131762963, 0).show();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      this.znD.setLastText(zok);
    }
    com.tencent.mm.plugin.masssend.a.jRu.a(getContext(), paramInt1, paramInt2, paramString);
    switch (paramInt2)
    {
    default: 
      Toast.makeText(this, 2131765235, 0).show();
      AppMethodBeat.o(26490);
      return;
    case -71: 
      com.tencent.mm.ui.base.h.d(this, getString(2131762974, new Object[] { Integer.valueOf(((cmq)((com.tencent.mm.plugin.masssend.a.f)paramq).rr.iLL.iLR).Msd) }), getString(2131755998), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26455);
          MassSendMsgUI.this.finish();
          AppMethodBeat.o(26455);
        }
      });
      AppMethodBeat.o(26490);
      return;
    }
    Toast.makeText(this, 2131762962, 0).show();
    AppMethodBeat.o(26490);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI
 * JD-Core Version:    0.7.0.1
 */