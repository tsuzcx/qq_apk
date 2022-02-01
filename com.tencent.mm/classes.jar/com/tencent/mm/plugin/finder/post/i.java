package com.tencent.mm.plugin.finder.post;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/SdkShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "extInfo", "getExtInfo", "setExtInfo", "fromAppId", "getFromAppId", "setFromAppId", "paramsJson", "getParamsJson", "setParamsJson", "postInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRemoteMediaInfo;", "getPostInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderRemoteMediaInfo;", "setPostInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderRemoteMediaInfo;)V", "remoteMediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getRemoteMediaList", "()Ljava/util/LinkedList;", "remoteUrl", "getRemoteUrl", "setRemoteUrl", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "source", "", "getSource", "()I", "setSource", "(I)V", "videoSource", "getVideoSource", "setVideoSource", "waitType", "getWaitType", "setWaitType", "canChooseCover", "", "canDelMedia", "canSaveDraft", "getShareAppId", "getShareAppSource", "getShareExtInfo", "getShareType", "onCreateBefore", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  public static final i.a EUl;
  public static final int EUq;
  public static final int EUr;
  public String AyS;
  public String AyT;
  private fby BrI;
  public bue EUm;
  public String EUn;
  public final LinkedList<dji> EUo;
  public int EUp;
  private final String TAG;
  public String clientId;
  public String extInfo;
  public int source;
  private int videoSource;
  
  static
  {
    AppMethodBeat.i(349408);
    EUl = new i.a((byte)0);
    EUq = 1;
    EUr = 2;
    AppMethodBeat.o(349408);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349402);
    this.TAG = "Finder.SdkShareUIC";
    this.EUn = "";
    this.extInfo = "";
    this.AyS = "";
    this.AyT = "";
    this.videoSource = 4;
    this.EUo = new LinkedList();
    this.clientId = "";
    AppMethodBeat.o(349402);
  }
  
  public final String eHB()
  {
    Object localObject2 = null;
    Object localObject1 = this.BrI;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label69;
      }
      localObject1 = this.EUm;
      if (localObject1 != null) {
        break label61;
      }
      localObject1 = localObject2;
    }
    label61:
    label69:
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      return localObject2;
      localObject1 = ((fby)localObject1).abBz;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((etj)localObject1).appid;
      break;
      localObject1 = ((bue)localObject1).EUn;
    }
  }
  
  public final boolean eHC()
  {
    return this.EUm == null;
  }
  
  public final boolean eHD()
  {
    return this.EUm == null;
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(349427);
    super.onCreateBefore(paramBundle);
    paramBundle = (a)new fby();
    Object localObject = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.BrI = ((fby)paramBundle);
      paramBundle = (a)new bue();
      localObject = getIntent().getByteArrayExtra("KEY_REMOTE_MEDIA_POST_INFO");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject);
        this.EUm = ((bue)paramBundle);
        this.EUn = eHB();
        int k = getIntent().getIntExtra("KEY_POST_FROM_APP_SOURCE", 0);
        i = k;
        if (k == 0)
        {
          paramBundle = this.EUm;
          if (paramBundle == null) {
            i = 0;
          }
        }
        else
        {
          this.source = i;
          localObject = getIntent().getStringExtra("KEY_MIAOJIAN_EXTINFO");
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            paramBundle = this.EUm;
            if (paramBundle != null) {
              break label531;
            }
            paramBundle = "";
          }
          this.extInfo = paramBundle;
          localObject = getIntent().getStringExtra("KEY_POST_REMOTE_URL");
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.AyS = paramBundle;
          localObject = getIntent().getStringExtra("KEY_POST_FROM_APP_PARAMJSON");
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.AyT = paramBundle;
          this.videoSource = getIntent().getIntExtra("KEY_SHARE_VIDEO_SOURCE", 4);
          paramBundle = this.EUm;
          if (paramBundle != null) {
            break label551;
          }
          paramBundle = "";
          this.clientId = paramBundle;
          paramBundle = this.EUm;
          if (paramBundle != null) {
            break label571;
          }
          i = 0;
          this.EUp = i;
          if (!Util.isNullOrNil(this.EUn))
          {
            paramBundle = v.FrN;
            v.Sz(this.videoSource);
            paramBundle = v.FrN;
            v.azO(this.EUn);
          }
          if (((CharSequence)this.EUn).length() != 0) {
            break label579;
          }
          i = 1;
          if (i != 0)
          {
            localObject = getIntent().getStringExtra("KEY_POST_MIAOJIAN_TONGKUAN_META");
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            i = j;
            if (((CharSequence)paramBundle).length() == 0) {
              i = 1;
            }
            if (i == 0)
            {
              this.extInfo = paramBundle;
              this.EUn = "wxa5e0de08d96cc09d";
              Log.i(this.TAG, s.X("miaojianTongkuanMeta ", paramBundle));
            }
          }
          paramBundle = this.EUm;
          if (paramBundle != null) {
            this.EUo.add(com.tencent.mm.plugin.finder.storage.data.i.a(paramBundle));
          }
          Log.i(this.TAG, "sdkshare, fromAppId:" + this.EUn + ", remoteUrl:" + this.AyS + ", paramsJson:" + this.AyT + ", extInfo:" + this.extInfo);
          AppMethodBeat.o(349427);
          return;
          paramBundle = paramBundle;
          Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          int i = paramBundle.aabW;
          continue;
          label531:
          localObject = paramBundle.aabX;
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            paramBundle = "";
            continue;
            label551:
            localObject = paramBundle.clientId;
            paramBundle = (Bundle)localObject;
            if (localObject == null)
            {
              paramBundle = "";
              continue;
              label571:
              i = paramBundle.EUp;
              continue;
              label579:
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.i
 * JD-Core Version:    0.7.0.1
 */