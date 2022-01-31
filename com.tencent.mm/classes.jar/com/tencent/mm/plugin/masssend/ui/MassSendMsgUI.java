package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private static String mbE = "";
  private String filePath;
  private TextView lxm;
  private ChatFooter maV;
  private String maX;
  private List<String> maY;
  private boolean maZ = false;
  private TextView mbD;
  private com.tencent.mm.ui.widget.a.c mbF;
  private b mbG;
  private AppPanel.a mbH = new MassSendMsgUI.9(this);
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  public static void GY(String paramString)
  {
    mbE = paramString;
  }
  
  private static void GZ(String paramString)
  {
    long l = com.tencent.mm.vfs.e.aeQ(paramString);
    int i = bk.g((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, 247, 255));
    com.tencent.mm.plugin.report.service.h.nFQ.a(106L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 246L, 1L, false);
    y.d("MicroMsg.MassSendMsgUI", "report video size res : " + i + " hadCompress : true fileLen : " + l / 1024L + "K");
  }
  
  private void M(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    paramIntent = new com.tencent.mm.plugin.masssend.a.a();
    paramIntent.maF = this.maX;
    paramIntent.maG = this.maY.size();
    paramIntent.filename = ((String)localObject);
    paramIntent.maH = i;
    paramIntent.msgType = 43;
    paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.maZ);
    au.Dk().a(paramIntent, 0);
    localObject = this.mController.uMN;
    getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.sendrequest_sending), true, new MassSendMsgUI.11(this, paramIntent));
  }
  
  private void N(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null) {
      return;
    }
    if (q.g((String)localObject, null, paramIntent.getBooleanExtra("CropImage_Compress_Img", true))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.masssend.a.h.bhd();
      paramIntent = com.tencent.mm.plugin.masssend.a.b.i((String)localObject, this.maX, this.maY.size(), i);
      if (paramIntent == null) {
        break;
      }
      paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.maZ, i);
      au.Dk().a(paramIntent, 0);
      localObject = this.mController.uMN;
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.sendrequest_sending), true, new MassSendMsgUI.12(this, paramIntent));
      return;
    }
  }
  
  private void O(Intent paramIntent)
  {
    if (!ab.bG(this))
    {
      com.tencent.mm.ui.base.h.a(this, R.l.video_export_file_warning, R.l.app_tip, new MassSendMsgUI.2(this, paramIntent), new MassSendMsgUI.3(this));
      return;
    }
    P(paramIntent);
  }
  
  private void P(Intent paramIntent)
  {
    com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new MassSendMsgUI.4(this, localc));
    localc.a(this, paramIntent, new MassSendMsgUI.5(this));
  }
  
  private void awX()
  {
    if (!com.tencent.mm.pluginsdk.ui.tools.l.c(this, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
    }
  }
  
  private boolean dN(String paramString1, String paramString2)
  {
    boolean bool = aq.is2G(this);
    int i;
    if (bool)
    {
      i = 10485760;
      label16:
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      i = SightVideoJNI.shouldRemuxing(paramString2, 660, 500, i, d, 1000000);
      y.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        return false;
        i = 26214400;
        break label16;
      }
    }
    o.Sr();
    GZ(t.nS(paramString1));
    return true;
    return false;
    o.Sr();
    String str = t.nS(paramString1);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString2);
    y.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[] { str });
    int m = bk.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
    int n = bk.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
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
    localObject = com.tencent.mm.modelcontrol.d.Nl().b(localVideoTransPara);
    int i2 = com.tencent.mm.plugin.sight.base.b.oeb;
    y.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", new Object[] { localVideoTransPara, localObject });
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
      k = SightVideoJNI.remuxing(paramString2, str, i, j, k, com.tencent.mm.plugin.sight.base.b.oea, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.oec, null, 0, false);
      if (k >= 0) {
        break label615;
      }
      y.w("MicroMsg.MassSendMsgUI", "remuxing video error");
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
    label615:
    GZ(str);
    o.Sr();
    paramString1 = t.nT(paramString1);
    if (!com.tencent.mm.vfs.e.bK(paramString1)) {
      y.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[] { paramString1 });
    }
    try
    {
      paramString2 = ThumbnailUtils.createVideoThumbnail(str, 1);
      if (paramString2 != null) {
        com.tencent.mm.sdk.platformtools.c.a(paramString2, 60, Bitmap.CompressFormat.JPEG, paramString1, true);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MassSendMsgUI", paramString1, "", new Object[0]);
        y.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[] { paramString1.getMessage() });
      }
    }
    y.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    return true;
  }
  
  protected final int getLayoutId()
  {
    return R.i.mass_send_msg;
  }
  
  protected final void initView()
  {
    boolean bool = true;
    setMMTitle(R.l.mass_send_msg);
    this.mbD = ((TextView)findViewById(R.h.mass_send_msg_contact_list));
    this.lxm = ((TextView)findViewById(R.h.mass_send_msg_contact_count));
    TextView localTextView = this.mbD;
    int j = (int)this.mbD.getTextSize();
    Object localObject;
    int i;
    if (this.maY == null)
    {
      localObject = new SpannableString("");
      localTextView.setText((CharSequence)localObject);
      this.lxm.setText(getResources().getQuantityString(R.j.mass_send_count, this.maY.size(), new Object[] { Integer.valueOf(this.maY.size()) }));
      this.maV = ((ChatFooter)findViewById(R.h.nav_footer));
      ((MassSendLayout)findViewById(R.h.mass_send_root_layout)).setPanel(this.maV.getPanel());
      this.maV.setCattingRootLayoutId(R.h.mass_send_root_layout);
      this.mbG = new b(this, this.maV, this.maX, this.maY, this.maZ);
      this.maV.setFooterEventListener(this.mbG);
      localObject = new d(this);
      this.maV.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject);
      localObject = this.maV;
      au.Hx();
      j = ((Integer)com.tencent.mm.model.c.Dz().get(18, Integer.valueOf(-1))).intValue();
      i = j;
      if (j == -1) {
        i = 1;
      }
      ((ChatFooter)localObject).setMode(i);
      this.maV.setUserName("masssendapp");
      this.maV.seR.refresh();
      au.Hx();
      if (((Boolean)com.tencent.mm.model.c.Dz().get(66832, Boolean.valueOf(false))).booleanValue())
      {
        this.maV.cnA();
        this.maV.cnw();
      }
      this.maV.addTextChangedListener(new MassSendMsgUI.8(this));
      this.maV.cnv();
      this.maV.cno();
      this.maV.cnu();
      this.maV.T(true, true);
      this.maV.cnt();
      this.maV.mb(true);
      this.maV.setAppPanelListener(this.mbH);
      localObject = this.maV;
      com.tencent.mm.br.d.coz();
      if (!com.tencent.mm.at.b.Pb()) {
        break label565;
      }
    }
    for (;;)
    {
      ((ChatFooter)localObject).mc(bool);
      this.maV.cnq();
      this.maV.cnz();
      setBackBtn(new MassSendMsgUI.1(this));
      return;
      localObject = new StringBuilder();
      i = 0;
      if (i < this.maY.size())
      {
        String str = r.gV((String)this.maY.get(i));
        if (i == this.maY.size() - 1) {
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
      label565:
      bool = false;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
    do
    {
      for (;;)
      {
        return;
        switch (paramInt1)
        {
        case 3: 
        default: 
          y.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
          return;
        case 1: 
          if (paramIntent != null)
          {
            if (paramIntent.getBooleanExtra("is_video", false))
            {
              paramIntent = paramIntent.getStringExtra("video_full_path");
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse("file://" + paramIntent));
              O((Intent)localObject);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("CropImageMode", 4);
            ((Intent)localObject).putExtra("CropImage_Filter", true);
            com.tencent.mm.pluginsdk.m localm = com.tencent.mm.plugin.masssend.a.eUR;
            au.Hx();
            localm.a(this, paramIntent, (Intent)localObject, com.tencent.mm.model.c.FG(), 4, null);
            return;
          }
          break;
        case 2: 
          localObject = getApplicationContext();
          au.Hx();
          this.filePath = com.tencent.mm.pluginsdk.ui.tools.l.f((Context)localObject, paramIntent, com.tencent.mm.model.c.FG());
          if (this.filePath != null)
          {
            paramIntent = new Intent();
            paramIntent.putExtra("CropImageMode", 4);
            paramIntent.putExtra("CropImage_Filter", true);
            paramIntent.putExtra("CropImage_ImgPath", this.filePath);
            com.tencent.mm.plugin.masssend.a.eUR.a(this.mController.uMN, paramIntent, 4);
            return;
          }
          break;
        case 4: 
          N(paramIntent);
          return;
        case 8: 
          paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (paramIntent != null) {
            if (paramIntent.mfh)
            {
              localObject = paramIntent.mfp;
              if (bk.bl((String)localObject)) {
                continue;
              }
              try
              {
                boolean bool = paramIntent.mfi;
                y.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[] { localObject });
                com.tencent.mm.plugin.masssend.a.h.bhd();
                paramIntent = com.tencent.mm.plugin.masssend.a.b.i((String)localObject, this.maX, this.maY.size(), 0);
                if (paramIntent != null)
                {
                  paramIntent = new com.tencent.mm.plugin.masssend.a.f(paramIntent, this.maZ, 0);
                  au.Dk().a(paramIntent, 0);
                  localObject = this.mController.uMN;
                  getString(R.l.app_tip);
                  this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.sendrequest_sending), true, new MassSendMsgUI.13(this, paramIntent));
                  return;
                }
              }
              catch (Exception paramIntent)
              {
                y.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[] { paramIntent.getMessage() });
                return;
              }
            }
          }
          break;
        }
      }
      y.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[] { paramIntent.mfj, paramIntent.mfk });
      o.Sr();
      Object localObject = t.nS(paramIntent.mfl);
      if (!paramIntent.mfj.equals(localObject))
      {
        y.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[] { paramIntent.mfj, localObject });
        com.tencent.mm.vfs.e.aA(paramIntent.mfj, (String)localObject);
      }
      localObject = paramIntent.mfl;
      paramInt1 = paramIntent.mfn;
      paramIntent = new com.tencent.mm.modelvideo.c();
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new MassSendMsgUI.14(this, paramIntent));
      com.tencent.mm.sdk.f.e.post(new MassSendMsgUI.15(this, (String)localObject, paramInt1), "MassSend_Remux");
      return;
    } while (paramIntent == null);
    if (paramIntent.getBooleanExtra("from_record", false))
    {
      M(paramIntent);
      return;
    }
    O(paramIntent);
    return;
    M(paramIntent);
    return;
    O(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(193, this);
    this.maZ = getIntent().getBooleanExtra("mass_send_again", false);
    this.maX = getIntent().getStringExtra("mass_send_contact_list");
    paramBundle = this.maX;
    this.maY = new ArrayList();
    if ((paramBundle == null) || (paramBundle.equals(""))) {}
    for (;;)
    {
      initView();
      return;
      paramBundle = paramBundle.split(";");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.maY = bk.G(paramBundle);
      }
    }
  }
  
  protected void onDestroy()
  {
    au.Dk().b(193, this);
    super.onDestroy();
    if (this.maV != null) {
      this.maV.destroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.maV.cnD()))
    {
      this.maV.setBottomPanelVisibility(8);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    this.maV.aRj();
    this.maV.onPause();
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      awX();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new MassSendMsgUI.10(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.maV != null)
    {
      this.maV.setLastText(mbE);
      this.maV.a(this.mController.uMN, this);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.mbG != null)
    {
      b localb = this.mbG;
      if (localb.tipDialog != null)
      {
        localb.tipDialog.dismiss();
        localb.tipDialog = null;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      mbE = "";
      paramString = new Intent(this, MassSendHistoryUI.class);
      paramString.addFlags(67108864);
      startActivity(paramString);
      finish();
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24))
    {
      y.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
      Toast.makeText(this, R.l.mass_send_err_spam, 0).show();
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      this.maV.setLastText(mbE);
    }
    com.tencent.mm.plugin.masssend.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString);
    switch (paramInt2)
    {
    default: 
      Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
      return;
    case -71: 
      paramInt1 = ((avz)((com.tencent.mm.plugin.masssend.a.f)paramm).dmK.ecF.ecN).trK;
      com.tencent.mm.ui.base.h.a(this, getString(R.l.mass_send_tolist_limit, new Object[] { Integer.valueOf(paramInt1) }), getString(R.l.app_tip), new MassSendMsgUI.7(this));
      return;
    }
    Toast.makeText(this, R.l.mass_send_err_freq_limit, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI
 * JD-Core Version:    0.7.0.1
 */