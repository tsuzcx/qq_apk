package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class GameVideoEditorProxyUI
  extends MMBaseActivity
{
  private String bHM;
  private com.tencent.mm.ui.widget.b.d iOd;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private boolean nlJ;
  private SparseArray<GameShareOption> nlK;
  private com.tencent.mm.plugin.sight.base.a nlL;
  private CaptureDataManager.b nlM;
  private String nlz;
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(151874);
    this.nlJ = true;
    this.nlM = new GameVideoEditorProxyUI.1(this);
    AppMethodBeat.o(151874);
  }
  
  private static String a(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(151876);
    Object localObject = paramCaptureVideoNormalModel.videoPath;
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo((String)localObject);
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem;
    if (locala == null)
    {
      ab.e("MicroMsg.GameVideoEditorProxyUI", "video after edited is error");
      localWebViewJSSDKVideoItem = null;
    }
    while (localWebViewJSSDKVideoItem == null)
    {
      AppMethodBeat.o(151876);
      return null;
      localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.ahu((String)localObject);
      localWebViewJSSDKVideoItem.duration = locala.cmu();
      localWebViewJSSDKVideoItem.width = locala.width;
      localWebViewJSSDKVideoItem.height = locala.height;
      localWebViewJSSDKVideoItem.size = ((int)com.tencent.mm.vfs.e.avI((String)localObject));
      com.tencent.mm.plugin.webview.modeltools.g.dcE().a(localWebViewJSSDKVideoItem);
    }
    paramCaptureVideoNormalModel = eC(paramCaptureVideoNormalModel.thumbPath, paramCaptureVideoNormalModel.videoPath);
    localObject = am.dbZ().ahh(paramCaptureVideoNormalModel);
    if (localObject != null) {
      localWebViewJSSDKVideoItem.hII = ((WebViewJSSDKFileItem)localObject).hgj;
    }
    paramCaptureVideoNormalModel = ar.b(localWebViewJSSDKVideoItem.ctV, paramCaptureVideoNormalModel, localWebViewJSSDKVideoItem.duration, localWebViewJSSDKVideoItem.height, localWebViewJSSDKVideoItem.width, localWebViewJSSDKVideoItem.size);
    AppMethodBeat.o(151876);
    return paramCaptureVideoNormalModel;
  }
  
  private static String eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151877);
    String str1 = paramString1;
    File localFile;
    if (TextUtils.isEmpty(paramString1))
    {
      localFile = new File(paramString2);
      String str2 = localFile.getName();
      str1 = null;
      paramString1 = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramString1 = str1;
        if (str2.contains(".")) {
          paramString1 = str2.substring(0, str2.lastIndexOf("."));
        }
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label177;
      }
      str1 = localFile.getParent() + "/" + paramString1 + ".jpeg";
    }
    while (!new File(str1).exists())
    {
      ab.i("MicroMsg.GameVideoEditorProxyUI", "create new thumb path:%s!", new Object[] { str1 });
      paramString1 = ThumbnailUtils.createVideoThumbnail(paramString2, 1);
      if (paramString1 == null)
      {
        ab.e("MicroMsg.GameVideoEditorProxyUI", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
        AppMethodBeat.o(151877);
        return "";
        label177:
        str1 = localFile.getParent() + "microMsg_" + System.currentTimeMillis() + ".jpeg";
      }
      else
      {
        paramString1 = ThumbnailUtils.extractThumbnail(paramString1, 690, 400, 2);
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramString1, 30, Bitmap.CompressFormat.JPEG, str1, true);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        paramString1 = WebViewJSSDKFileItem.hr(str1, str1);
        paramString1.hgn = true;
        paramString1.cth = 1;
        com.tencent.mm.plugin.webview.modeltools.g.dcE().a(paramString1);
        paramString1 = paramString1.ctV;
        AppMethodBeat.o(151877);
        return paramString1;
      }
      catch (IOException paramString1)
      {
        ab.e("MicroMsg.GameVideoEditorProxyUI", "saveBitmapToImage exist IOException:" + paramString1.getMessage());
        continue;
      }
      ab.i("MicroMsg.GameVideoEditorProxyUI", "file is exist for path:%s!", new Object[] { str1 });
    }
    AppMethodBeat.o(151877);
    return "";
  }
  
  private String eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151880);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://game.weixin.qq.com/cgi-bin/h5/static/moment/publish.html");
    localStringBuffer.append("?video_info=");
    String str = "";
    if (paramString2 == null) {
      paramString2 = new com.tencent.mm.aa.i();
    }
    try
    {
      paramString2.f("videoUrl", paramString1);
      paramString2.f("thumbUrl", getIntent().getStringExtra("thumb_url"));
      label76:
      paramString1 = paramString2.toString();
      localStringBuffer.append(URLEncoder.encode(paramString1));
      localStringBuffer.append("&from=");
      if (this.mFrom == 1) {
        localStringBuffer.append(3);
      }
      for (;;)
      {
        for (;;)
        {
          localStringBuffer.append("&appid=");
          localStringBuffer.append(this.mAppId);
          localStringBuffer.append("&game_info=");
          localStringBuffer.append(getIntent().getStringExtra("game_info"));
          ab.i("MicroMsg.GameVideoEditorProxyUI", "publish url:%s", new Object[] { localStringBuffer.toString() });
          paramString1 = localStringBuffer.toString();
          AppMethodBeat.o(151880);
          return paramString1;
          try
          {
            paramString1 = new JSONArray(paramString2).getJSONObject(0).toString();
          }
          catch (JSONException paramString1)
          {
            ab.e("MicroMsg.GameVideoEditorProxyUI", "json_err:%s", new Object[] { paramString1.getMessage() });
            paramString1 = str;
          }
        }
        break;
        if (this.mFrom == 2) {
          localStringBuffer.append(2);
        }
      }
    }
    catch (com.tencent.mm.aa.g paramString1)
    {
      break label76;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151879);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.GameVideoEditorProxyUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    if (paramInt1 == 121)
    {
      if (paramInt2 != -1) {
        break label284;
      }
      if (paramIntent != null)
      {
        localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (localObject != null)
        {
          boolean bool = paramIntent.getBooleanExtra("video_edited", false);
          ab.i("MicroMsg.GameVideoEditorProxyUI", "output videoPath:%s, thumbPath:%s, videoEdited:%b", new Object[] { ((SightCaptureResult)localObject).oFI, ((SightCaptureResult)localObject).oFJ, Boolean.valueOf(bool) });
          if ((this.nlJ) && (bool) && (com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yEJ, true)))
          {
            String str = com.tencent.mm.plugin.mmsight.d.TY("mp4");
            ab.i("MicroMsg.GameVideoEditorProxyUI", "auto save %s exportPath %s", new Object[] { ((SightCaptureResult)localObject).oFI, str });
            com.tencent.mm.vfs.e.C(((SightCaptureResult)localObject).oFI, str);
            b.a(str, ah.getContext());
          }
        }
        switch (this.mFrom)
        {
        }
      }
    }
    label284:
    do
    {
      for (;;)
      {
        setResult(paramInt2, paramIntent);
        finish();
        if (this.mFrom == 1) {
          com.tencent.mm.pluginsdk.ui.tools.i.c(this.nlz, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(151879);
        return;
        al.p(new GameVideoEditorProxyUI.2(this, paramIntent), 0L);
        AppMethodBeat.o(151879);
        return;
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      }
      ab.e("MicroMsg.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, com.tencent.mm.game.report.b.a.a(this.mFrom, (Map)localObject));
      t.makeText(this.mContext, 2131300476, 1).show();
    } while (this.mFrom != 1);
    setResult(paramInt2, paramIntent);
    finish();
    com.tencent.mm.pluginsdk.ui.tools.i.c(this.nlz, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(151879);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151875);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.nlz = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.bHM = getIntent().getStringExtra("video_path");
    Object localObject1;
    label274:
    int i;
    if (getIntent().getBooleanExtra("need_edit", false))
    {
      ab.i("MicroMsg.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.bHM });
      this.nlL = com.tencent.mm.plugin.sight.base.d.Zo(this.bHM);
      if (this.nlL == null)
      {
        ab.e("MicroMsg.GameVideoEditorProxyUI", "video is error");
        finish();
        ab.i("MicroMsg.GameVideoEditorProxyUI", "onCreate");
        AppMethodBeat.o(151875);
        return;
      }
      long l = System.currentTimeMillis();
      paramBundle = new StringBuilder();
      o.alD();
      paramBundle = o.getAccVideoPath() + "vsg_output_" + l + ".mp4";
      localObject1 = new StringBuilder();
      o.alD();
      localObject1 = o.getAccVideoPath() + "vsg_thumb_" + l + ".jpg";
      paramBundle = RecordConfigProvider.aa(this.bHM, paramBundle, (String)localObject1);
      if ((this.mFrom == 1) || (this.mFrom == 4))
      {
        paramBundle.qbq = com.tencent.mm.modelcontrol.d.afW().lf(1);
        paramBundle.qbz = false;
        paramBundle.scene = 5;
        localObject1 = new UICustomParam.a();
        i = SightVideoJNI.getMp4Rotate(this.bHM);
        if ((i != 0) && (i != 180)) {
          break label501;
        }
        if (this.nlL.width < this.nlL.height) {
          break label1006;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label331:
      if (i != 0)
      {
        ((UICustomParam.a)localObject1).etB.etr = 0.6F;
        ((UICustomParam.a)localObject1).etB.ets = 0.6F;
        ((UICustomParam.a)localObject1).etB.ett = 0.5F;
        ((UICustomParam.a)localObject1).etB.etu = 0.5F;
      }
      label412:
      Object localObject2;
      switch (this.mFrom)
      {
      default: 
        paramBundle.qbr = ((UICustomParam.a)localObject1).etB;
        CaptureDataManager.qbh.qbg = this.nlM;
        localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
        localObject1 = this.mContext;
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.a((Activity)localObject1, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 3);
        if (localObject2 != null) {
          break;
        }
      }
      for (i = 0; i != 0; i = 1)
      {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
        break;
        paramBundle.qbq = com.tencent.mm.modelcontrol.d.afW().lf(0);
        break label274;
        label501:
        if (((i != 270) && (i != 90)) || (this.nlL.height < this.nlL.width)) {
          break label1006;
        }
        i = 1;
        break label331;
        paramBundle.qbx = (paramBundle.qbq.duration * 1000);
        ((UICustomParam.a)localObject1).f(2130839047, 2131690709, getString(2131300474));
        break label412;
        paramBundle.qbx = 7200000;
        paramBundle.qbm = 2;
        localObject2 = getIntent().getBundleExtra("minigame_ext_data");
        if (localObject2 != null)
        {
          Object localObject3 = ((Bundle)localObject2).getString("k_ext_wording");
          VideoTransPara localVideoTransPara = (VideoTransPara)((Bundle)localObject2).getParcelable("k_preferred_trans_param");
          if (localVideoTransPara != null)
          {
            ab.i("MicroMsg.GameVideoEditorProxyUI", "hy: has given trasn params: %s", new Object[] { localVideoTransPara.toString() });
            paramBundle.qbq = localVideoTransPara;
          }
          if (!bo.isNullOrNil((String)localObject3))
          {
            i = getResources().getColor(2131690709);
            ((UICustomParam.a)localObject1).etB.ety = ((String)localObject3);
            ((UICustomParam.a)localObject1).etB.etz = i;
            ((UICustomParam.a)localObject1).etB.etA = 17.0F;
          }
          localObject2 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            if (((ArrayList)localObject2).size() == 1) {
              ((UICustomParam.a)localObject1).f(0, 0, ((GameShareOption)((ArrayList)localObject2).get(0)).title);
            }
            for (;;)
            {
              this.nlK = new SparseArray();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (GameShareOption)((Iterator)localObject2).next();
                this.nlK.put(((GameShareOption)localObject3).id, localObject3);
              }
              ((UICustomParam.a)localObject1).f(0, 0, getString(2131297073));
            }
          }
          ((UICustomParam.a)localObject1).f(0, 0, getString(2131297073));
        }
        for (;;)
        {
          ((UICustomParam.a)localObject1).etB.etv.put("plugin_crop", Boolean.TRUE);
          break;
          ((UICustomParam.a)localObject1).f(0, 0, getString(2131297073));
        }
        ((Intent)localObject2).putExtra("KEY_PARAMS_CONFIG", paramBundle);
        ((Intent)localObject2).putExtra("KEY_PARAMS_TO_WHERE", 3);
        ((Intent)localObject2).putExtra("KEY_PARAMS_EXIT_ANIM", -1);
        ab.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
        ((Activity)localObject1).startActivityForResult((Intent)localObject2, 121);
        com.tencent.mm.plugin.recordvideo.jumper.a.U((Context)localObject1, -1);
      }
      paramBundle = eD(getIntent().getStringExtra("video_url"), null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramBundle);
      com.tencent.mm.bq.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 131);
      break;
      label1006:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(151878);
    super.onDestroy();
    AppMethodBeat.o(151878);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */