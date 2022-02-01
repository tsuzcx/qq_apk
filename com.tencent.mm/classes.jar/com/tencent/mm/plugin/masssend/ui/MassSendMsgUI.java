package com.tencent.mm.plugin.masssend.ui;

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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.g.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MassSendMsgUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static String KOf = "";
  private String KNA;
  private boolean KNB;
  private ChatFooter KNy;
  private TextView KOe;
  private com.tencent.mm.ui.widget.a.e KOg;
  private b KOh;
  private AppPanel.a KOi;
  private String filePath;
  private List<String> lDu;
  private TextView noi;
  private w tipDialog;
  
  public MassSendMsgUI()
  {
    AppMethodBeat.i(26474);
    this.tipDialog = null;
    this.KNB = false;
    this.KOi = new AppPanel.a()
    {
      public final void aar(int paramAnonymousInt)
      {
        AppMethodBeat.i(26463);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(26463);
          return;
          t.a(MassSendMsgUI.this, 1, 1, 3, 3, false, null);
          AppMethodBeat.o(26463);
          return;
          u localu = new u(com.tencent.mm.loader.i.b.bmL());
          if ((!localu.jKS()) && (!localu.jKY()))
          {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gzM), 1).show();
            AppMethodBeat.o(26463);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.getContext(), "android.permission.CAMERA", 16, "");
          Log.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), MassSendMsgUI.this.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(26463);
            return;
          }
          MassSendMsgUI.c(MassSendMsgUI.this);
        }
      }
      
      public final void aas(int paramAnonymousInt)
      {
        AppMethodBeat.i(26467);
        MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousInt);
        AppMethodBeat.o(26467);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg) {}
      
      public final void gaA() {}
      
      public final void gaB() {}
      
      public final void gak()
      {
        AppMethodBeat.i(26458);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNC), 0).show();
        AppMethodBeat.o(26458);
      }
      
      public final void gal()
      {
        AppMethodBeat.i(26459);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNq), 0).show();
        AppMethodBeat.o(26459);
      }
      
      public final void gam()
      {
        AppMethodBeat.i(26460);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNA), 0).show();
        AppMethodBeat.o(26460);
      }
      
      public final void gan()
      {
        AppMethodBeat.i(26461);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNw), 0).show();
        AppMethodBeat.o(26461);
      }
      
      public final void gao()
      {
        AppMethodBeat.i(26462);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNq), 0).show();
        AppMethodBeat.o(26462);
      }
      
      public final void gap()
      {
        AppMethodBeat.i(26464);
        com.tencent.mm.plugin.masssend.a.pFn.cL(MassSendMsgUI.this);
        AppMethodBeat.o(26464);
      }
      
      public final void gaq()
      {
        AppMethodBeat.i(26465);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNq), 0).show();
        AppMethodBeat.o(26465);
      }
      
      public final void gar() {}
      
      public final void gas()
      {
        AppMethodBeat.i(26466);
        Intent localIntent = new Intent();
        localIntent.putExtra("preceding_scence", 13);
        com.tencent.mm.br.c.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
        AppMethodBeat.o(26466);
      }
      
      public final void gat()
      {
        AppMethodBeat.i(26468);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gNx), 0).show();
        AppMethodBeat.o(26468);
      }
      
      public final void gau() {}
      
      public final void gav() {}
      
      public final void gaw() {}
      
      public final void gax() {}
      
      public final void gay() {}
      
      public final void gaz() {}
    };
    AppMethodBeat.o(26474);
  }
  
  public static void aKY(String paramString)
  {
    KOf = paramString;
  }
  
  private static void aKZ(String paramString)
  {
    AppMethodBeat.i(26491);
    long l = y.bEl(paramString);
    int i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, 247, 255));
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 246L, 1L, false);
    Log.d("MicroMsg.MassSendMsgUI", "report video size res : " + i + " hadCompress : true fileLen : " + l / 1024L + "K");
    AppMethodBeat.o(26491);
  }
  
  private void bb(final Intent paramIntent)
  {
    AppMethodBeat.i(26483);
    Object localObject = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    paramIntent = new com.tencent.mm.plugin.masssend.model.a();
    paramIntent.KNh = this.KNA;
    paramIntent.KNi = this.lDu.size();
    paramIntent.filename = ((String)localObject);
    paramIntent.KNj = i;
    paramIntent.msgType = 43;
    paramIntent = new com.tencent.mm.plugin.masssend.model.f(paramIntent, this.KNB);
    bh.aZW().a(paramIntent, 0);
    localObject = getContext();
    getString(R.l.app_tip);
    this.tipDialog = k.a((Context)localObject, getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26470);
        bh.aZW().a(paramIntent);
        AppMethodBeat.o(26470);
      }
    });
    AppMethodBeat.o(26483);
  }
  
  private void bc(final Intent paramIntent)
  {
    AppMethodBeat.i(26484);
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null)
    {
      AppMethodBeat.o(26484);
      return;
    }
    if (z.h((String)localObject, null, paramIntent.getBooleanExtra("CropImage_Compress_Img", true))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.masssend.model.g.fZV();
      paramIntent = com.tencent.mm.plugin.masssend.model.b.o((String)localObject, this.KNA, this.lDu.size(), i);
      if (paramIntent != null) {
        break;
      }
      AppMethodBeat.o(26484);
      return;
    }
    paramIntent = new com.tencent.mm.plugin.masssend.model.f(paramIntent, this.KNB, i);
    bh.aZW().a(paramIntent, 0);
    localObject = getContext();
    getString(R.l.app_tip);
    this.tipDialog = k.a((Context)localObject, getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26471);
        bh.aZW().a(paramIntent);
        AppMethodBeat.o(26471);
      }
    });
    AppMethodBeat.o(26484);
  }
  
  private void bd(final Intent paramIntent)
  {
    AppMethodBeat.i(26487);
    if (!ah.eb(this))
    {
      k.a(this, R.l.video_export_file_warning, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    be(paramIntent);
    AppMethodBeat.o(26487);
  }
  
  private void be(Intent paramIntent)
  {
    AppMethodBeat.i(26488);
    final com.tencent.mm.modelvideo.g localg = new com.tencent.mm.modelvideo.g();
    getString(R.l.app_tip);
    this.tipDialog = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localg.oYi = null;
      }
    });
    localg.a(this, paramIntent, this.KNA, false, new g.a()
    {
      public final void a(int paramAnonymousInt1, final String paramAnonymousString1, String paramAnonymousString2, final String paramAnonymousString3, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(272758);
        Log.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString3 });
        if ((paramAnonymousInt1 < 0) && (paramAnonymousInt1 != -50002))
        {
          Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.video_export_file_error), 0).show();
          if (MassSendMsgUI.d(MassSendMsgUI.this) != null)
          {
            MassSendMsgUI.d(MassSendMsgUI.this).dismiss();
            MassSendMsgUI.e(MassSendMsgUI.this);
            AppMethodBeat.o(272758);
          }
        }
        else
        {
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26452);
              if (MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousString1, paramAnonymousString3))
              {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(26450);
                    MassSendMsgUI.a(MassSendMsgUI.this, MassSendMsgUI.6.1.this.val$fileName, MassSendMsgUI.6.1.this.srg);
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
                  Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.video_export_file_too_big), 0).show();
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
        AppMethodBeat.o(272758);
      }
    });
    AppMethodBeat.o(26488);
  }
  
  private void fBt()
  {
    AppMethodBeat.i(26481);
    if (!t.d(this, com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(26481);
  }
  
  private void fO(String paramString, int paramInt)
  {
    AppMethodBeat.i(26486);
    final com.tencent.mm.modelvideo.g localg = new com.tencent.mm.modelvideo.g();
    getString(R.l.app_tip);
    this.tipDialog = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localg.oYi = null;
      }
    });
    ThreadPool.post(new MassSendMsgUI.2(this, paramString, paramInt), "MassSend_Remux");
    AppMethodBeat.o(26486);
  }
  
  private boolean kd(String paramString1, String paramString2)
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
    v.bOh();
    aKZ(com.tencent.mm.modelvideo.aa.PX(paramString1));
    AppMethodBeat.o(26489);
    return true;
    AppMethodBeat.o(26489);
    return false;
    v.bOh();
    String str = com.tencent.mm.modelvideo.aa.PX(paramString1);
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
    com.tencent.mm.plugin.sight.base.f.a(paramString2, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
    localVideoTransPara.duration = (((PInt)localObject).value / 1000);
    localVideoTransPara.width = localPInt1.value;
    localVideoTransPara.height = localPInt2.value;
    localVideoTransPara.fps = localPInt3.value;
    localVideoTransPara.videoBitrate = localPInt4.value;
    localObject = com.tencent.mm.modelcontrol.e.bIg().c(localVideoTransPara);
    int i2 = com.tencent.mm.plugin.sight.base.d.PFk;
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
      k = SightVideoJNI.remuxingVFS(paramString2, str, i, j, k, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.PFl, null, 0, false, 0, 51);
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
    aKZ(str);
    v.bOh();
    paramString1 = com.tencent.mm.modelvideo.aa.PY(paramString1);
    if (!y.ZC(paramString1)) {
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
    return R.i.glz;
  }
  
  public void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(26479);
    setMMTitle(R.l.glz);
    this.KOe = ((TextView)findViewById(R.h.fNT));
    this.noi = ((TextView)findViewById(R.h.fNS));
    TextView localTextView = this.KOe;
    int j = (int)this.KOe.getTextSize();
    if (this.lDu == null) {}
    for (Object localObject = new SpannableString("");; localObject = com.tencent.mm.pluginsdk.ui.span.p.d(this, ((StringBuilder)localObject).toString(), j))
    {
      localTextView.setText((CharSequence)localObject);
      this.noi.setText(getResources().getQuantityString(R.j.gpo, this.lDu.size(), new Object[] { Integer.valueOf(this.lDu.size()) }));
      this.KNy = ((ChatFooter)findViewById(R.h.fOZ));
      ((MassSendLayout)findViewById(R.h.fNX)).setPanel(this.KNy.getPanel());
      this.KNy.setCattingRootLayoutId(R.h.fNX);
      this.KOh = new b(this, this.KNy, this.KNA, this.lDu, this.KNB);
      this.KNy.setFooterEventListener(this.KOh);
      localObject = new d(this);
      this.KNy.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject);
      localObject = this.KNy;
      bh.bCz();
      j = ((Integer)com.tencent.mm.model.c.ban().d(18, Integer.valueOf(-1))).intValue();
      int i = j;
      if (j == -1) {
        i = 1;
      }
      ((ChatFooter)localObject).setMode(i);
      this.KNy.setUserName("masssendapp");
      this.KNy.Yfb.bDL();
      this.KNy.Yfb.iLH();
      this.KNy.Yfb.iLI();
      this.KNy.Yfb.iLJ();
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().d(66832, Boolean.FALSE)).booleanValue())
      {
        this.KNy.iMv();
        this.KNy.iMa();
      }
      this.KNy.addTextChangedListener(new TextWatcher()
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
            paramAnonymousInt2 = MassSendMsgUI.this.getResources().getDimensionPixelSize(R.f.LargePadding);
            localImageView.setPadding(paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2);
            MassSendMsgUI.a(MassSendMsgUI.this, k.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.gzE), localImageView, MassSendMsgUI.this.getString(R.l.app_ok), MassSendMsgUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
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
            MassSendMsgUI.b(MassSendMsgUI.this).F(paramAnonymousCharSequence, -1, false);
            MassSendMsgUI.aGP(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(26457);
        }
      });
      this.KNy.Yfb.iLE();
      this.KNy.Yfb.iLB();
      this.KNy.Yfb.iLD();
      this.KNy.bG(true, true);
      this.KNy.iMr();
      this.KNy.JN(true);
      this.KNy.setAppPanelListener(this.KOi);
      localObject = this.KNy;
      if ((com.tencent.mm.br.c.iPe()) || (com.tencent.mm.au.b.bKI())) {
        bool = true;
      }
      ((ChatFooter)localObject).JO(bool);
      this.KNy.Yfb.iLF();
      this.KNy.Yfb.iLG();
      this.KNy.Yfb.iLK();
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
      if (i < this.lDu.size())
      {
        String str = com.tencent.mm.model.aa.getDisplayName((String)this.lDu.get(i));
        if (i == this.lDu.size() - 1) {
          ((StringBuilder)localObject).append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(str + ",  ");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
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
        bd((Intent)localObject1);
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
      bc((Intent)localObject2);
      AppMethodBeat.o(26485);
      return;
    case 2: 
      localObject1 = getApplicationContext();
      bh.bCz();
      this.filePath = t.g((Context)localObject1, paramIntent, com.tencent.mm.model.c.bzL());
      if (this.filePath == null)
      {
        AppMethodBeat.o(26485);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 4);
      paramIntent.putExtra("CropImage_Filter", true);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.masssend.a.dNP().a(getContext(), paramIntent, 4);
      AppMethodBeat.o(26485);
      return;
    case 4: 
      bc(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 9: 
      localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
      paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
      if (localObject1 != null)
      {
        if (((CaptureDataManager.CaptureVideoNormalModel)localObject1).NHK.booleanValue())
        {
          paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
          if (!Util.isNullOrNil(paramIntent)) {
            try
            {
              Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.model.g.fZV();
              paramIntent = com.tencent.mm.plugin.masssend.model.b.o(paramIntent, this.KNA, this.lDu.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.model.f(paramIntent, this.KNB, 0);
              bh.aZW().a(paramIntent, 0);
              localObject1 = getContext();
              getString(R.l.app_tip);
              this.tipDialog = k.a((Context)localObject1, getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(26472);
                  bh.aZW().a(paramIntent);
                  AppMethodBeat.o(26472);
                }
              });
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
        paramIntent = y.bEq(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
        v.bOh();
        localObject2 = com.tencent.mm.modelvideo.aa.PX(paramIntent);
        if (!((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath.equals(localObject2))
        {
          Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, localObject2 });
          y.qn(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, (String)localObject2);
        }
        fO(paramIntent, (int)(((CaptureDataManager.CaptureVideoNormalModel)localObject1).NHJ.longValue() / 1000L));
      }
      AppMethodBeat.o(26485);
      return;
    case 8: 
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent != null)
      {
        if (paramIntent.KTL)
        {
          paramIntent = paramIntent.KTT;
          if (!Util.isNullOrNil(paramIntent)) {
            try
            {
              Log.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.model.g.fZV();
              paramIntent = com.tencent.mm.plugin.masssend.model.b.o(paramIntent, this.KNA, this.lDu.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.model.f(paramIntent, this.KNB, 0);
              bh.aZW().a(paramIntent, 0);
              localObject1 = getContext();
              getString(R.l.app_tip);
              this.tipDialog = k.a((Context)localObject1, getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(26473);
                  bh.aZW().a(paramIntent);
                  AppMethodBeat.o(26473);
                }
              });
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
        Log.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { paramIntent.KTN, paramIntent.KTO });
        v.bOh();
        localObject1 = com.tencent.mm.modelvideo.aa.PX(paramIntent.KTP);
        if (!paramIntent.KTN.equals(localObject1))
        {
          Log.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { paramIntent.KTN, localObject1 });
          y.qn(paramIntent.KTN, (String)localObject1);
        }
        fO(paramIntent.KTP, paramIntent.KTR);
      }
      AppMethodBeat.o(26485);
      return;
    case 7: 
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bb(paramIntent);
          AppMethodBeat.o(26485);
          return;
        }
        bd(paramIntent);
        AppMethodBeat.o(26485);
        return;
      }
      break;
    case 5: 
      bb(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 6: 
      bd(paramIntent);
      AppMethodBeat.o(26485);
      return;
    }
    AppMethodBeat.o(26485);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26475);
    super.onCreate(paramBundle);
    bh.aZW().a(193, this);
    this.KNB = getIntent().getBooleanExtra("mass_send_again", false);
    this.KNA = getIntent().getStringExtra("mass_send_contact_list");
    paramBundle = this.KNA;
    this.lDu = new ArrayList();
    if ((paramBundle == null) || (paramBundle.equals(""))) {}
    for (;;)
    {
      initView();
      AppMethodBeat.o(26475);
      return;
      paramBundle = paramBundle.split(";");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.lDu = Util.stringsToList(paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26477);
    bh.aZW().b(193, this);
    super.onDestroy();
    if (this.KNy != null) {
      this.KNy.destroy();
    }
    AppMethodBeat.o(26477);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26480);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.KNy.iMz()))
    {
      this.KNy.setBottomPanelVisibility(8);
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
    this.KNy.a(ChatFooter.h.YjA);
    this.KNy.onPause();
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
        fBt();
        AppMethodBeat.o(26482);
        return;
      }
      k.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26469);
          com.tencent.mm.pluginsdk.permission.b.lx(MassSendMsgUI.this.getContext());
          AppMethodBeat.o(26469);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26476);
    super.onResume();
    if (this.KNy != null)
    {
      this.KNy.setLastText(KOf);
      this.KNy.a(getContext(), this);
    }
    AppMethodBeat.o(26476);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(26490);
    Log.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.KOh != null)
    {
      b localb = this.KOh;
      if (localb.tipDialog != null)
      {
        localb.tipDialog.dismiss();
        localb.tipDialog = null;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      KOf = "";
      paramString = new Intent(this, MassSendHistoryUI.class);
      paramString.addFlags(67108864);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24))
    {
      Log.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
      Toast.makeText(this, R.l.gNu, 0).show();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      this.KNy.setLastText(KOf);
    }
    com.tencent.mm.plugin.masssend.a.pFo.a(getContext(), paramInt1, paramInt2, paramString);
    switch (paramInt2)
    {
    default: 
      Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
      AppMethodBeat.o(26490);
      return;
    case -71: 
      paramInt1 = ((dmo)c.c.b(((com.tencent.mm.plugin.masssend.model.f)paramp).rr.otC)).aaSR;
      k.d(this, getString(R.l.gNB, new Object[] { Integer.valueOf(paramInt1) }), getString(R.l.app_tip), new DialogInterface.OnClickListener()
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
    Toast.makeText(this, R.l.gNt, 0).show();
    AppMethodBeat.o(26490);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI
 * JD-Core Version:    0.7.0.1
 */