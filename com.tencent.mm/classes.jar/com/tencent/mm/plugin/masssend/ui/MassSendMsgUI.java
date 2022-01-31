package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MassSendMsgUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private static String oCf = "";
  private String filePath;
  private TextView nUz;
  private boolean oBA;
  private ChatFooter oBw;
  private String oBy;
  private List<String> oBz;
  private TextView oCe;
  private com.tencent.mm.ui.widget.b.c oCg;
  private b oCh;
  private AppPanel.a oCi;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public MassSendMsgUI()
  {
    AppMethodBeat.i(22851);
    this.tipDialog = null;
    this.oBA = false;
    this.oCi = new MassSendMsgUI.10(this);
    AppMethodBeat.o(22851);
  }
  
  public static void SJ(String paramString)
  {
    oCf = paramString;
  }
  
  private static void SK(String paramString)
  {
    AppMethodBeat.i(22867);
    long l = com.tencent.mm.vfs.e.avI(paramString);
    int i = bo.g((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, 247, 255));
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 246L, 1L, false);
    ab.d("MicroMsg.MassSendMsgUI", "report video size res : " + i + " hadCompress : true fileLen : " + l / 1024L + "K");
    AppMethodBeat.o(22867);
  }
  
  private void af(Intent paramIntent)
  {
    AppMethodBeat.i(22860);
    Object localObject = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    paramIntent = new com.tencent.mm.plugin.masssend.a.a();
    paramIntent.oBe = this.oBy;
    paramIntent.oBf = this.oBz.size();
    paramIntent.filename = ((String)localObject);
    paramIntent.oBg = i;
    paramIntent.msgType = 43;
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.oBA);
    aw.Rc().a(paramIntent, 0);
    localObject = getContext();
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131303128), true, new MassSendMsgUI.12(this, paramIntent));
    AppMethodBeat.o(22860);
  }
  
  private void ag(final Intent paramIntent)
  {
    AppMethodBeat.i(22861);
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null)
    {
      AppMethodBeat.o(22861);
      return;
    }
    if (r.g((String)localObject, null, paramIntent.getBooleanExtra("CropImage_Compress_Img", true))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.masssend.a.h.bPc();
      paramIntent = com.tencent.mm.plugin.masssend.a.b.j((String)localObject, this.oBy, this.oBz.size(), i);
      if (paramIntent != null) {
        break;
      }
      AppMethodBeat.o(22861);
      return;
    }
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.oBA, i);
    aw.Rc().a(paramIntent, 0);
    localObject = getContext();
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131303128), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(22847);
        aw.Rc().a(paramIntent);
        AppMethodBeat.o(22847);
      }
    });
    AppMethodBeat.o(22861);
  }
  
  private void ah(final Intent paramIntent)
  {
    AppMethodBeat.i(22863);
    if (!ac.cm(this))
    {
      com.tencent.mm.ui.base.h.a(this, 2131304515, 2131297087, new DialogInterface.OnClickListener()new MassSendMsgUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(153542);
          MassSendMsgUI.b(MassSendMsgUI.this, paramIntent);
          AppMethodBeat.o(153542);
        }
      }, new MassSendMsgUI.4(this));
      AppMethodBeat.o(22863);
      return;
    }
    ai(paramIntent);
    AppMethodBeat.o(22863);
  }
  
  private void ai(Intent paramIntent)
  {
    AppMethodBeat.i(22864);
    com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new MassSendMsgUI.5(this, localc));
    localc.a(this, paramIntent, new MassSendMsgUI.6(this));
    AppMethodBeat.o(22864);
  }
  
  private void bEq()
  {
    AppMethodBeat.i(22858);
    if (!com.tencent.mm.pluginsdk.ui.tools.n.c(this, com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131303074), 1).show();
    }
    AppMethodBeat.o(22858);
  }
  
  private void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(153550);
    com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new MassSendMsgUI.16(this, localc));
    com.tencent.mm.sdk.g.d.post(new MassSendMsgUI.2(this, paramString, paramInt), "MassSend_Remux");
    AppMethodBeat.o(153550);
  }
  
  private boolean fg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22865);
    boolean bool = at.is2G(this);
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
      i = SightVideoJNI.shouldRemuxing(paramString2, 660, 500, i, d, 1000000);
      ab.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(22865);
        return false;
        i = 26214400;
        break label22;
      }
    }
    o.alE();
    SK(t.vf(paramString1));
    AppMethodBeat.o(22865);
    return true;
    AppMethodBeat.o(22865);
    return false;
    o.alE();
    String str = t.vf(paramString1);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString2);
    ab.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[] { str });
    int m = bo.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
    int n = bo.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    Object localObject = new PInt();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    PInt localPInt3 = new PInt();
    PInt localPInt4 = new PInt();
    com.tencent.mm.plugin.sight.base.d.a(paramString2, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
    localVideoTransPara.duration = (((PInt)localObject).value / 1000);
    localVideoTransPara.width = localPInt1.value;
    localVideoTransPara.height = localPInt2.value;
    localVideoTransPara.fps = localPInt3.value;
    localVideoTransPara.videoBitrate = localPInt4.value;
    localObject = com.tencent.mm.modelcontrol.d.afW().c(localVideoTransPara);
    int i2 = com.tencent.mm.plugin.sight.base.b.qSq;
    ab.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", new Object[] { localVideoTransPara, localObject });
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
      localMediaMetadataRetriever.release();
      k = SightVideoJNI.remuxing(paramString2, str, i, j, k, com.tencent.mm.plugin.sight.base.b.qSp, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.qSr, null, 0, false, 0, 51);
      if (k >= 0) {
        break label646;
      }
      ab.w("MicroMsg.MassSendMsgUI", "remuxing video error");
      AppMethodBeat.o(22865);
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
    SK(str);
    o.alE();
    paramString1 = t.vg(paramString1);
    if (!com.tencent.mm.vfs.e.cN(paramString1)) {
      ab.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[] { paramString1 });
    }
    try
    {
      paramString2 = ThumbnailUtils.createVideoThumbnail(str, 1);
      if (paramString2 != null) {
        com.tencent.mm.sdk.platformtools.d.a(paramString2, 60, Bitmap.CompressFormat.JPEG, paramString1, true);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MassSendMsgUI", paramString1, "", new Object[0]);
        ab.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[] { paramString1.getMessage() });
      }
    }
    ab.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    AppMethodBeat.o(22865);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130970125;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(22856);
    setMMTitle(2131301533);
    this.oCe = ((TextView)findViewById(2131826108));
    this.nUz = ((TextView)findViewById(2131826107));
    TextView localTextView = this.oCe;
    int j = (int)this.oCe.getTextSize();
    Object localObject;
    int i;
    if (this.oBz == null)
    {
      localObject = new SpannableString("");
      localTextView.setText((CharSequence)localObject);
      this.nUz.setText(getResources().getQuantityString(2131361810, this.oBz.size(), new Object[] { Integer.valueOf(this.oBz.size()) }));
      this.oBw = ((ChatFooter)findViewById(2131822454));
      ((MassSendLayout)findViewById(2131826106)).setPanel(this.oBw.getPanel());
      this.oBw.setCattingRootLayoutId(2131826106);
      this.oCh = new b(this, this.oBw, this.oBy, this.oBz, this.oBA);
      this.oBw.setFooterEventListener(this.oCh);
      localObject = new d(this);
      this.oBw.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject);
      localObject = this.oBw;
      aw.aaz();
      j = ((Integer)com.tencent.mm.model.c.Ru().get(18, Integer.valueOf(-1))).intValue();
      i = j;
      if (j == -1) {
        i = 1;
      }
      ((ChatFooter)localObject).setMode(i);
      this.oBw.setUserName("masssendapp");
      this.oBw.vVV.refresh();
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(66832, Boolean.FALSE)).booleanValue())
      {
        this.oBw.dow();
        this.oBw.dog();
      }
      this.oBw.addTextChangedListener(new MassSendMsgUI.9(this));
      this.oBw.vVV.dnQ();
      this.oBw.vVV.dnN();
      this.oBw.vVV.dnP();
      this.oBw.ad(true, true);
      this.oBw.vVV.dnO();
      this.oBw.pj(true);
      this.oBw.setAppPanelListener(this.oCi);
      localObject = this.oBw;
      com.tencent.mm.bq.d.dpU();
      if (!com.tencent.mm.au.b.aic()) {
        break label594;
      }
    }
    for (;;)
    {
      ((ChatFooter)localObject).pk(bool);
      this.oBw.vVV.dnR();
      this.oBw.vVV.dnS();
      setBackBtn(new MassSendMsgUI.1(this));
      AppMethodBeat.o(22856);
      return;
      localObject = new StringBuilder();
      i = 0;
      if (i < this.oBz.size())
      {
        String str = s.nE((String)this.oBz.get(i));
        if (i == this.oBz.size() - 1) {
          ((StringBuilder)localObject).append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(str + ",  ");
        }
      }
      localObject = j.b(this, ((StringBuilder)localObject).toString(), j);
      break;
      label594:
      bool = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22862);
    ab.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(22862);
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (paramInt1)
    {
    case 3: 
    default: 
      ab.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(22862);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(22862);
        return;
      }
      if (paramIntent.getBooleanExtra("is_video", false))
      {
        paramIntent = paramIntent.getStringExtra("video_full_path");
        localObject1 = new Intent();
        ((Intent)localObject1).setData(Uri.parse("file://".concat(String.valueOf(paramIntent))));
        ah((Intent)localObject1);
        AppMethodBeat.o(22862);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = com.tencent.mm.plugin.masssend.a.gmO;
      aw.aaz();
      ((com.tencent.mm.pluginsdk.n)localObject2).a(this, paramIntent, (Intent)localObject1, com.tencent.mm.model.c.YK(), 4, null);
      AppMethodBeat.o(22862);
      return;
    case 2: 
      localObject1 = getApplicationContext();
      aw.aaz();
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.n.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.YK());
      if (this.filePath == null)
      {
        AppMethodBeat.o(22862);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 4);
      paramIntent.putExtra("CropImage_Filter", true);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.masssend.a.gmO.a(getContext(), paramIntent, 4);
      AppMethodBeat.o(22862);
      return;
    case 4: 
      ag(paramIntent);
      AppMethodBeat.o(22862);
      return;
    case 9: 
      localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
      paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
      if (localObject1 != null)
      {
        if (((CaptureDataManager.CaptureVideoNormalModel)localObject1).qbk.booleanValue())
        {
          paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
          if (!bo.isNullOrNil(paramIntent)) {
            try
            {
              ab.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.bPc();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.j(paramIntent, this.oBy, this.oBz.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(22862);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.oBA, 0);
              aw.Rc().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131297087);
              this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131303128), true, new MassSendMsgUI.14(this, paramIntent));
              AppMethodBeat.o(22862);
              return;
            }
            catch (Exception paramIntent)
            {
              ab.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(22862);
          return;
        }
        ab.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath });
        paramIntent = com.tencent.mm.vfs.e.avM(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
        o.alE();
        localObject2 = t.vf(paramIntent);
        if (!((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath.equals(localObject2))
        {
          ab.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, localObject2 });
          com.tencent.mm.vfs.e.aT(((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, (String)localObject2);
        }
        cB(paramIntent, (int)(((CaptureDataManager.CaptureVideoNormalModel)localObject1).qbj.longValue() / 1000L));
      }
      AppMethodBeat.o(22862);
      return;
    case 8: 
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent != null)
      {
        if (paramIntent.oFG)
        {
          paramIntent = paramIntent.oFO;
          if (!bo.isNullOrNil(paramIntent)) {
            try
            {
              ab.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { paramIntent });
              com.tencent.mm.plugin.masssend.a.h.bPc();
              paramIntent = com.tencent.mm.plugin.masssend.a.b.j(paramIntent, this.oBy, this.oBz.size(), 0);
              if (paramIntent == null)
              {
                AppMethodBeat.o(22862);
                return;
              }
              paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.oBA, 0);
              aw.Rc().a(paramIntent, 0);
              localObject1 = getContext();
              getString(2131297087);
              this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131303128), true, new MassSendMsgUI.15(this, paramIntent));
              AppMethodBeat.o(22862);
              return;
            }
            catch (Exception paramIntent)
            {
              ab.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
            }
          }
          AppMethodBeat.o(22862);
          return;
        }
        ab.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { paramIntent.oFI, paramIntent.oFJ });
        o.alE();
        localObject1 = t.vf(paramIntent.oFK);
        if (!paramIntent.oFI.equals(localObject1))
        {
          ab.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { paramIntent.oFI, localObject1 });
          com.tencent.mm.vfs.e.aT(paramIntent.oFI, (String)localObject1);
        }
        cB(paramIntent.oFK, paramIntent.oFM);
      }
      AppMethodBeat.o(22862);
      return;
    case 7: 
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          af(paramIntent);
          AppMethodBeat.o(22862);
          return;
        }
        ah(paramIntent);
        AppMethodBeat.o(22862);
        return;
      }
      break;
    case 5: 
      af(paramIntent);
      AppMethodBeat.o(22862);
      return;
    case 6: 
      ah(paramIntent);
      AppMethodBeat.o(22862);
      return;
    }
    AppMethodBeat.o(22862);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22852);
    super.onCreate(paramBundle);
    aw.Rc().a(193, this);
    this.oBA = getIntent().getBooleanExtra("mass_send_again", false);
    this.oBy = getIntent().getStringExtra("mass_send_contact_list");
    paramBundle = this.oBy;
    this.oBz = new ArrayList();
    if ((paramBundle == null) || (paramBundle.equals(""))) {}
    for (;;)
    {
      initView();
      AppMethodBeat.o(22852);
      return;
      paramBundle = paramBundle.split(";");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.oBz = bo.P(paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22854);
    aw.Rc().b(193, this);
    super.onDestroy();
    if (this.oBw != null) {
      this.oBw.destroy();
    }
    AppMethodBeat.o(22854);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22857);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.oBw.doB()))
    {
      this.oBw.setBottomPanelVisibility(8);
      AppMethodBeat.o(22857);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22857);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22855);
    this.oBw.bxy();
    this.oBw.onPause();
    super.onPause();
    AppMethodBeat.o(22855);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22859);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(22859);
      return;
    }
    ab.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22859);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(22859);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131297837), false, new MassSendMsgUI.11(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22853);
    super.onResume();
    if (this.oBw != null)
    {
      this.oBw.setLastText(oCf);
      this.oBw.a(getContext(), this);
    }
    AppMethodBeat.o(22853);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(22866);
    ab.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.oCh != null)
    {
      b localb = this.oCh;
      if (localb.tipDialog != null)
      {
        localb.tipDialog.dismiss();
        localb.tipDialog = null;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      oCf = "";
      paramString = new Intent(this, MassSendHistoryUI.class);
      paramString.addFlags(67108864);
      startActivity(paramString);
      finish();
      AppMethodBeat.o(22866);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24))
    {
      ab.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
      Toast.makeText(this, 2131301528, 0).show();
      AppMethodBeat.o(22866);
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      this.oBw.setLastText(oCf);
    }
    com.tencent.mm.plugin.masssend.a.gmP.a(getContext(), paramInt1, paramInt2, paramString);
    switch (paramInt2)
    {
    default: 
      Toast.makeText(this, 2131303126, 0).show();
      AppMethodBeat.o(22866);
      return;
    case -71: 
      com.tencent.mm.ui.base.h.a(this, getString(2131301539, new Object[] { Integer.valueOf(((bco)((com.tencent.mm.plugin.masssend.a.f)paramm).rr.fsW.fta).xrN) }), getString(2131297087), new MassSendMsgUI.8(this));
      AppMethodBeat.o(22866);
      return;
    }
    Toast.makeText(this, 2131301527, 0).show();
    AppMethodBeat.o(22866);
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