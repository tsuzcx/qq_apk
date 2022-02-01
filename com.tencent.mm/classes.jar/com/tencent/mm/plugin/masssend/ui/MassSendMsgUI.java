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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MassSendMsgUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static String twI = "";
  private String filePath;
  private List<String> fsY;
  private TextView sIt;
  private p tipDialog;
  private TextView twH;
  private com.tencent.mm.ui.widget.a.d twJ;
  private b twK;
  private AppPanel.a twL;
  private ChatFooter twb;
  private String twd;
  private boolean twe;
  
  public MassSendMsgUI()
  {
    AppMethodBeat.i(26474);
    this.tipDialog = null;
    this.twe = false;
    this.twL = new AppPanel.a()
    {
      public final void Gq(int paramAnonymousInt)
      {
        AppMethodBeat.i(26463);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(26463);
          return;
          com.tencent.mm.pluginsdk.ui.tools.q.a(MassSendMsgUI.this, 1, 1, 3, 3, null);
          AppMethodBeat.o(26463);
          return;
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.ais());
          if ((!locale.exists()) && (!locale.mkdirs()))
          {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131757320), 1).show();
            AppMethodBeat.o(26463);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
          ad.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), MassSendMsgUI.this.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(26463);
            return;
          }
          MassSendMsgUI.c(MassSendMsgUI.this);
        }
      }
      
      public final void Gr(int paramAnonymousInt)
      {
        AppMethodBeat.i(26467);
        MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousInt);
        AppMethodBeat.o(26467);
      }
      
      public final void cOf()
      {
        AppMethodBeat.i(26458);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761188), 0).show();
        AppMethodBeat.o(26458);
      }
      
      public final void cOg()
      {
        AppMethodBeat.i(26459);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761170), 0).show();
        AppMethodBeat.o(26459);
      }
      
      public final void cOh()
      {
        AppMethodBeat.i(26460);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761186), 0).show();
        AppMethodBeat.o(26460);
      }
      
      public final void cOi()
      {
        AppMethodBeat.i(26461);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761179), 0).show();
        AppMethodBeat.o(26461);
      }
      
      public final void cOj()
      {
        AppMethodBeat.i(26462);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761170), 0).show();
        AppMethodBeat.o(26462);
      }
      
      public final void cOk()
      {
        AppMethodBeat.i(26464);
        com.tencent.mm.plugin.masssend.a.hYt.bC(MassSendMsgUI.this);
        AppMethodBeat.o(26464);
      }
      
      public final void cOl()
      {
        AppMethodBeat.i(26465);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761170), 0).show();
        AppMethodBeat.o(26465);
      }
      
      public final void cOm() {}
      
      public final void cOn()
      {
        AppMethodBeat.i(26466);
        Intent localIntent = new Intent();
        localIntent.putExtra("preceding_scence", 13);
        com.tencent.mm.bs.d.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
        AppMethodBeat.o(26466);
      }
      
      public final void cOo()
      {
        AppMethodBeat.i(26468);
        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131761180), 0).show();
        AppMethodBeat.o(26468);
      }
      
      public final void cOp() {}
      
      public final void cOq() {}
      
      public final void cOr() {}
      
      public final void cOs() {}
      
      public final void cOt() {}
      
      public final void cOu() {}
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg) {}
      
      public final void fXT() {}
    };
    AppMethodBeat.o(26474);
  }
  
  public static void afK(String paramString)
  {
    twI = paramString;
  }
  
  private static void afL(String paramString)
  {
    AppMethodBeat.i(26491);
    long l = i.aMN(paramString);
    int i = bt.l((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, 247, 255));
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 246L, 1L, false);
    ad.d("MicroMsg.MassSendMsgUI", "report video size res : " + i + " hadCompress : true fileLen : " + l / 1024L + "K");
    AppMethodBeat.o(26491);
  }
  
  private void au(final Intent paramIntent)
  {
    AppMethodBeat.i(26483);
    Object localObject = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    paramIntent = new com.tencent.mm.plugin.masssend.a.a();
    paramIntent.tvJ = this.twd;
    paramIntent.tvK = this.fsY.size();
    paramIntent.filename = ((String)localObject);
    paramIntent.tvL = i;
    paramIntent.msgType = 43;
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.twe);
    az.aeS().a(paramIntent, 0);
    localObject = getContext();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26470);
        az.aeS().a(paramIntent);
        AppMethodBeat.o(26470);
      }
    });
    AppMethodBeat.o(26483);
  }
  
  private void av(final Intent paramIntent)
  {
    AppMethodBeat.i(26484);
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null)
    {
      AppMethodBeat.o(26484);
      return;
    }
    if (u.f((String)localObject, null, paramIntent.getBooleanExtra("CropImage_Compress_Img", true))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.masssend.a.h.cNS();
      paramIntent = com.tencent.mm.plugin.masssend.a.b.l((String)localObject, this.twd, this.fsY.size(), i);
      if (paramIntent != null) {
        break;
      }
      AppMethodBeat.o(26484);
      return;
    }
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.twe, i);
    az.aeS().a(paramIntent, 0);
    localObject = getContext();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26471);
        az.aeS().a(paramIntent);
        AppMethodBeat.o(26471);
      }
    });
    AppMethodBeat.o(26484);
  }
  
  private void aw(final Intent paramIntent)
  {
    AppMethodBeat.i(26487);
    if (!ae.cJ(this))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764676, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    ax(paramIntent);
    AppMethodBeat.o(26487);
  }
  
  private void ax(Intent paramIntent)
  {
    AppMethodBeat.i(26488);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.hxK = null;
      }
    });
    localc.a(this, paramIntent, new c.a()
    {
      public final void c(int paramAnonymousInt1, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(26453);
        ad.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2 });
        if ((paramAnonymousInt1 < 0) && (paramAnonymousInt1 != -50002))
        {
          Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131764674), 0).show();
          if (MassSendMsgUI.d(MassSendMsgUI.this) != null)
          {
            MassSendMsgUI.d(MassSendMsgUI.this).dismiss();
            MassSendMsgUI.e(MassSendMsgUI.this);
            AppMethodBeat.o(26453);
          }
        }
        else
        {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26452);
              if (MassSendMsgUI.a(MassSendMsgUI.this, paramAnonymousString1, paramAnonymousString2))
              {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(26450);
                    MassSendMsgUI.a(MassSendMsgUI.this, MassSendMsgUI.6.1.this.cPO, MassSendMsgUI.6.1.this.khF);
                    AppMethodBeat.o(26450);
                  }
                });
                AppMethodBeat.o(26452);
                return;
              }
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26451);
                  Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131764675), 0).show();
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
  
  private void cAv()
  {
    AppMethodBeat.i(26481);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(this, com.tencent.mm.loader.j.b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(26481);
  }
  
  private void dD(String paramString, int paramInt)
  {
    AppMethodBeat.i(26486);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.hxK = null;
      }
    });
    com.tencent.mm.sdk.g.b.c(new MassSendMsgUI.2(this, paramString, paramInt), "MassSend_Remux");
    AppMethodBeat.o(26486);
  }
  
  private boolean hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26489);
    boolean bool = ay.is2G(this);
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
      ad.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(26489);
        return false;
        i = 26214400;
        break label22;
      }
    }
    o.aCI();
    afL(com.tencent.mm.modelvideo.t.zQ(paramString1));
    AppMethodBeat.o(26489);
    return true;
    AppMethodBeat.o(26489);
    return false;
    o.aCI();
    String str = com.tencent.mm.modelvideo.t.zQ(paramString1);
    com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
    locald.setDataSource(paramString2);
    ad.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[] { str });
    int m = bt.getInt(locald.extractMetadata(18), 0);
    int n = bt.getInt(locald.extractMetadata(19), 0);
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
    localObject = com.tencent.mm.modelcontrol.d.awT().c(localVideoTransPara);
    int i2 = com.tencent.mm.plugin.sight.base.c.wrb;
    ad.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", new Object[] { localVideoTransPara, localObject });
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
      k = SightVideoJNI.remuxingVFS(paramString2, str, i, j, k, com.tencent.mm.plugin.sight.base.c.wra, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.wrc, null, 0, false, 0, 51);
      if (k >= 0) {
        break label646;
      }
      ad.w("MicroMsg.MassSendMsgUI", "remuxing video error");
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
    afL(str);
    o.aCI();
    paramString1 = com.tencent.mm.modelvideo.t.zR(paramString1);
    if (!i.eK(paramString1)) {
      ad.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[] { paramString1 });
    }
    try
    {
      paramString2 = com.tencent.mm.sdk.platformtools.f.createVideoThumbnail(str, 1);
      if (paramString2 != null) {
        com.tencent.mm.sdk.platformtools.f.a(paramString2, 60, Bitmap.CompressFormat.JPEG, paramString1, true);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MassSendMsgUI", paramString1, "", new Object[0]);
        ad.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[] { paramString1.getMessage() });
      }
    }
    ad.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    AppMethodBeat.o(26489);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131494740;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(26479);
    setMMTitle(2131761181);
    this.twH = ((TextView)findViewById(2131302187));
    this.sIt = ((TextView)findViewById(2131302186));
    TextView localTextView = this.twH;
    int j = (int)this.twH.getTextSize();
    Object localObject;
    int i;
    if (this.fsY == null)
    {
      localObject = new SpannableString("");
      localTextView.setText((CharSequence)localObject);
      this.sIt.setText(getResources().getQuantityString(2131623956, this.fsY.size(), new Object[] { Integer.valueOf(this.fsY.size()) }));
      this.twb = ((ChatFooter)findViewById(2131302672));
      ((MassSendLayout)findViewById(2131302191)).setPanel(this.twb.getPanel());
      this.twb.setCattingRootLayoutId(2131302191);
      this.twK = new b(this, this.twb, this.twd, this.fsY, this.twe);
      this.twb.setFooterEventListener(this.twK);
      localObject = new d(this);
      this.twb.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject);
      localObject = this.twb;
      az.arV();
      j = ((Integer)com.tencent.mm.model.c.afk().get(18, Integer.valueOf(-1))).intValue();
      i = j;
      if (j == -1) {
        i = 1;
      }
      ((ChatFooter)localObject).setMode(i);
      this.twb.setUserName("masssendapp");
      this.twb.Cbx.refresh();
      this.twb.Cbx.eyC();
      this.twb.Cbx.eyD();
      this.twb.Cbx.fZG();
      az.arV();
      if (((Boolean)com.tencent.mm.model.c.afk().get(66832, Boolean.FALSE)).booleanValue())
      {
        this.twb.ezm();
        this.twb.eyU();
      }
      this.twb.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(26457);
          paramAnonymousCharSequence = String.valueOf(paramAnonymousCharSequence);
          final String str = paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3);
          if (((MassSendMsgUI.a(MassSendMsgUI.this) == null) || (!MassSendMsgUI.a(MassSendMsgUI.this).isShowing())) && (com.tencent.mm.sdk.platformtools.t.aFl(str)))
          {
            Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.e(str, 300, 300, false);
            if (localBitmap == null)
            {
              ad.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
              AppMethodBeat.o(26457);
              return;
            }
            ImageView localImageView = new ImageView(MassSendMsgUI.this);
            localImageView.setImageBitmap(localBitmap);
            paramAnonymousInt2 = MassSendMsgUI.this.getResources().getDimensionPixelSize(2131165480);
            localImageView.setPadding(paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2, paramAnonymousInt2);
            MassSendMsgUI.a(MassSendMsgUI.this, com.tencent.mm.ui.base.h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(2131757310), localImageView, MassSendMsgUI.this.getString(2131755835), MassSendMsgUI.this.getString(2131755691), new DialogInterface.OnClickListener()
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
            MassSendMsgUI.b(MassSendMsgUI.this).w(paramAnonymousCharSequence, -1, false);
            MassSendMsgUI.acC(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(26457);
        }
      });
      this.twb.Cbx.eyz();
      this.twb.Cbx.eyw();
      this.twb.Cbx.eyy();
      this.twb.aC(true, true);
      this.twb.Cbx.eyx();
      this.twb.uf(true);
      this.twb.setAppPanelListener(this.twL);
      localObject = this.twb;
      com.tencent.mm.bs.d.eBj();
      if (!com.tencent.mm.ax.b.azj()) {
        break label624;
      }
    }
    for (;;)
    {
      ((ChatFooter)localObject).ug(bool);
      this.twb.Cbx.eyA();
      this.twb.Cbx.eyB();
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
      if (i < this.fsY.size())
      {
        String str = v.sh((String)this.fsY.get(i));
        if (i == this.fsY.size() - 1) {
          ((StringBuilder)localObject).append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(str + ",  ");
        }
      }
      localObject = com.tencent.mm.pluginsdk.ui.span.k.b(this, ((StringBuilder)localObject).toString(), j);
      break;
      label624:
      bool = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(26485);
    ad.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      ad.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
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
        aw((Intent)localObject1);
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
      av((Intent)localObject2);
      AppMethodBeat.o(26485);
      return;
    case 2: 
      localObject1 = getApplicationContext();
      az.arV();
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.apW());
      if (this.filePath == null)
      {
        AppMethodBeat.o(26485);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 4);
      paramIntent.putExtra("CropImage_Filter", true);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.masssend.a.hYt.a(getContext(), paramIntent, 4);
      AppMethodBeat.o(26485);
      return;
    case 4: 
      av(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 9: 
      localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
      paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
      if (localObject1 != null)
      {
        if (((CaptureDataManager.CaptureVideoNormalModel)localObject1).vhz.booleanValue())
        {
          paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
          if (!bt.isNullOrNil(paramIntent)) {
            try
            {
              ad.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.cNS();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.l(paramIntent, this.twd, this.fsY.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.twe, 0);
              az.aeS().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131755906);
              this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(26472);
                  az.aeS().a(paramIntent);
                  AppMethodBeat.o(26472);
                }
              });
              AppMethodBeat.o(26485);
              return;
            }
            catch (Exception paramIntent)
            {
              ad.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(26485);
          return;
        }
        ad.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath });
        paramIntent = i.aMS(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
        o.aCI();
        localObject2 = com.tencent.mm.modelvideo.t.zQ(paramIntent);
        if (!((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath.equals(localObject2))
        {
          ad.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, localObject2 });
          i.lD(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, (String)localObject2);
        }
        dD(paramIntent, (int)(((CaptureDataManager.CaptureVideoNormalModel)localObject1).vhy.longValue() / 1000L));
      }
      AppMethodBeat.o(26485);
      return;
    case 8: 
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent != null)
      {
        if (paramIntent.tAP)
        {
          paramIntent = paramIntent.tAX;
          if (!bt.isNullOrNil(paramIntent)) {
            try
            {
              ad.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.cNS();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.l(paramIntent, this.twd, this.fsY.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(26485);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.twe, 0);
              az.aeS().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131755906);
              this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(26473);
                  az.aeS().a(paramIntent);
                  AppMethodBeat.o(26473);
                }
              });
              AppMethodBeat.o(26485);
              return;
            }
            catch (Exception paramIntent)
            {
              ad.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(26485);
          return;
        }
        ad.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { paramIntent.tAR, paramIntent.tAS });
        o.aCI();
        localObject1 = com.tencent.mm.modelvideo.t.zQ(paramIntent.tAT);
        if (!paramIntent.tAR.equals(localObject1))
        {
          ad.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { paramIntent.tAR, localObject1 });
          i.lD(paramIntent.tAR, (String)localObject1);
        }
        dD(paramIntent.tAT, paramIntent.tAV);
      }
      AppMethodBeat.o(26485);
      return;
    case 7: 
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          au(paramIntent);
          AppMethodBeat.o(26485);
          return;
        }
        aw(paramIntent);
        AppMethodBeat.o(26485);
        return;
      }
      break;
    case 5: 
      au(paramIntent);
      AppMethodBeat.o(26485);
      return;
    case 6: 
      aw(paramIntent);
      AppMethodBeat.o(26485);
      return;
    }
    AppMethodBeat.o(26485);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26475);
    super.onCreate(paramBundle);
    az.aeS().a(193, this);
    this.twe = getIntent().getBooleanExtra("mass_send_again", false);
    this.twd = getIntent().getStringExtra("mass_send_contact_list");
    paramBundle = this.twd;
    this.fsY = new ArrayList();
    if ((paramBundle == null) || (paramBundle.equals(""))) {}
    for (;;)
    {
      initView();
      AppMethodBeat.o(26475);
      return;
      paramBundle = paramBundle.split(";");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.fsY = bt.S(paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26477);
    az.aeS().b(193, this);
    super.onDestroy();
    if (this.twb != null) {
      this.twb.destroy();
    }
    AppMethodBeat.o(26477);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26480);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.twb.ezq()))
    {
      this.twb.setBottomPanelVisibility(8);
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
    this.twb.a(ChatFooter.h.CfE);
    this.twb.onPause();
    super.onPause();
    AppMethodBeat.o(26478);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26482);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(26482);
      return;
    }
    ad.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26482);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cAv();
        AppMethodBeat.o(26482);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26469);
          paramAnonymousDialogInterface = MassSendMsgUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(26469);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26476);
    super.onResume();
    if (this.twb != null)
    {
      this.twb.setLastText(twI);
      this.twb.a(getContext(), this);
    }
    AppMethodBeat.o(26476);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26490);
    ad.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.twK != null)
    {
      b localb = this.twK;
      if (localb.tipDialog != null)
      {
        localb.tipDialog.dismiss();
        localb.tipDialog = null;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      twI = "";
      paramString = new Intent(this, MassSendHistoryUI.class);
      paramString.addFlags(67108864);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendMsgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24))
    {
      ad.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
      Toast.makeText(this, 2131761176, 0).show();
      AppMethodBeat.o(26490);
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      this.twb.setLastText(twI);
    }
    com.tencent.mm.plugin.masssend.a.hYu.a(getContext(), paramInt1, paramInt2, paramString);
    switch (paramInt2)
    {
    default: 
      Toast.makeText(this, 2131763075, 0).show();
      AppMethodBeat.o(26490);
      return;
    case -71: 
      com.tencent.mm.ui.base.h.d(this, getString(2131761187, new Object[] { Integer.valueOf(((bpa)((com.tencent.mm.plugin.masssend.a.f)paramn).rr.gUT.gUX).DMy) }), getString(2131755906), new DialogInterface.OnClickListener()
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
    Toast.makeText(this, 2131761175, 0).show();
    AppMethodBeat.o(26490);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI
 * JD-Core Version:    0.7.0.1
 */