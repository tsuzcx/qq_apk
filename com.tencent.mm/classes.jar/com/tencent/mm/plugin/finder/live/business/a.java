package com.tencent.mm.plugin.finder.live.business;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.aw;
import com.tencent.mm.plugin.finder.live.model.aw.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadKt;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/business/LiveSeiSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "innerTag", "getInnerTag", "value", "", "lastAudioMode", "setLastAudioMode", "(Z)V", "lastScreenShareMode", "setLastScreenShareMode", "logicTag", "getLogicTag", "setLogicTag", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "processCallback", "getProcessCallback", "()Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "setProcessCallback", "(Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;)V", "checkAnchorAudioModeBySei", "", "userStatus", "", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkSeiServerTime", "anchorServerTime", "", "anchorIdBySei", "notifyMicUserVolume", "notityAnchorInfoBySei", "anchorUserId", "songId", "playStatus", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "release", "setAudioModePreviewPluginInvisble", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private final String CuJ;
  private String CuK;
  public aw CuL;
  private boolean CuM;
  private boolean CuN;
  private String TAG;
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(350948);
    this.CuJ = "LiveSeiSlice";
    this.CuK = "";
    this.TAG = "";
    AppMethodBeat.o(350948);
  }
  
  private final void ehm()
  {
    AppMethodBeat.i(350954);
    ThreadKt.uiThread((kotlin.g.a.a)new a.a(this));
    AppMethodBeat.o(350954);
  }
  
  public final void awi(String paramString)
  {
    AppMethodBeat.i(350960);
    s.u(paramString, "<set-?>");
    this.CuK = paramString;
    AppMethodBeat.o(350960);
  }
  
  public final String getTAG()
  {
    AppMethodBeat.i(350970);
    String str = s.X(this.CuJ, this.CuK);
    AppMethodBeat.o(350970);
    return str;
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(351018);
    Object localObject1 = e.g.mKv;
    Object localObject2;
    Object localObject3;
    label288:
    Object localObject4;
    Object localObject5;
    boolean bool;
    if (paramInt == e.g.bcY())
    {
      if (((j)business(j.class)).EfM)
      {
        Log.i(getTAG(), "EVENT_CDN_SEI_MESSAGE_LINK_MIC: roomPk = true, skip");
        AppMethodBeat.o(351018);
        return;
      }
      if (paramBundle == null) {
        paramBundle = null;
      }
      while (paramBundle != null)
      {
        localObject1 = new dlg();
        localObject2 = (com.tencent.mm.bx.a)localObject1;
        localObject3 = kotlin.n.d.UTF_8;
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(351018);
          throw paramBundle;
          paramBundle = paramBundle.getString("live_cdn_sei_msg");
        }
        else
        {
          paramBundle = paramBundle.getBytes((Charset)localObject3);
          s.s(paramBundle, "(this as java.lang.String).getBytes(charset)");
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom(paramBundle);
            paramBundle = ah.aiuX;
            paramBundle = getTAG();
            localObject2 = new StringBuilder("EVENT_CDN_SEI_MESSAGE_LINK_MIC micSEIMsg.infos:");
            localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
            localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.live.view.convert.a.gL((List)((dlg)localObject1).ToF)).append(" audienceLinkMicUserList:");
            localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
            Log.i(paramBundle, com.tencent.mm.plugin.finder.live.view.convert.a.gM(((j)business(j.class)).Efw));
            paramBundle = (Collection)((dlg)localObject1).ToF;
            if ((paramBundle == null) || (paramBundle.isEmpty()))
            {
              paramInt = 1;
              if (paramInt == 0) {
                break label288;
              }
              paramBundle = this.CuL;
              if (paramBundle == null) {
                break;
              }
              aw.a.a(paramBundle, b.c.neD);
              paramBundle = ah.aiuX;
              AppMethodBeat.o(351018);
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
              continue;
              paramInt = 0;
            }
            paramBundle = this.CuL;
            if (paramBundle != null)
            {
              aw.a.a(paramBundle, b.c.neC);
              paramBundle = ah.aiuX;
            }
            ehm();
            localObject2 = new ah.a();
            ((ah.a)localObject2).aiwY = true;
            localObject3 = new LinkedList();
            paramBundle = ((dlg)localObject1).ToF;
            s.s(paramBundle, "micSEIMsg.infos");
            localObject4 = ((Iterable)paramBundle).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (dlh)((Iterator)localObject4).next();
              paramBundle = ((j)business(j.class)).Efx;
              s.s(paramBundle, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
              synchronized ((Iterable)paramBundle)
              {
                ??? = ((Iterable)???).iterator();
                for (;;)
                {
                  if (((Iterator)???).hasNext())
                  {
                    paramBundle = ((Iterator)???).next();
                    bool = Util.isEqual(((h)paramBundle).mXL, ((dlh)localObject5).YRR);
                    if (bool)
                    {
                      paramBundle = (h)paramBundle;
                      if (paramBundle != null) {
                        break label497;
                      }
                      ((ah.a)localObject2).aiwY = false;
                      break;
                    }
                  }
                }
                paramBundle = null;
              }
              label497:
              paramInt = ((dlh)localObject5).aaRl;
              localObject5 = e.m.mLr;
              paramBundle.EbG = com.tencent.mm.ae.d.ee(paramInt, e.m.bdw());
              ((LinkedList)localObject3).add(paramBundle);
            }
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b((ah.a)localObject2, (dlg)localObject1, this, (LinkedList)localObject3));
            paramBundle = ah.aiuX;
          }
        }
      }
      AppMethodBeat.o(351018);
      return;
    }
    localObject1 = e.g.mKv;
    label618:
    int i;
    int j;
    if (paramInt == e.g.bda()) {
      if (paramBundle == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label2200;
        }
        localObject1 = new i((String)localObject1);
        localObject2 = e.r.mLO;
        localObject2 = ((i)localObject1).optString(e.r.getUserId());
        if (localObject2 != null) {
          break label1640;
        }
        localObject2 = "";
        localObject3 = e.r.mLO;
        i = ((i)localObject1).optInt(e.r.bdI());
        localObject3 = e.r.mLO;
        paramInt = ((i)localObject1).optInt(e.r.bdJ());
        localObject3 = e.r.mLO;
        j = ((i)localObject1).optInt(e.r.bdK());
        localObject3 = e.r.mLO;
        long l1 = ((i)localObject1).optLong(e.r.bdL());
        if (!Util.isEqual((String)localObject2, ((f)business(f.class)).mZr.aaOw)) {
          break label1643;
        }
        long l2 = cn.bDv();
        ((j)business(j.class)).EfI = k.bR(l2 - l1, 0L);
        Log.d(getTAG(), "anchorServerTime:" + l1 + " myServerTime:" + l2);
        label762:
        localObject3 = getTAG();
        localObject4 = new StringBuilder("notityAnchorInfoBySei anchorUserId:").append(localObject2).append('-').append(((f)business(f.class)).mZr.aaOw).append(" lastAudioMode:").append(this.CuM).append(" lastScreenShareMode:").append(this.CuN).append(" userStatus:").append(i).append(" songId:").append(paramInt).append(", playStatus:").append(j).append(" coverUrl:");
        localObject1 = ((e)business(e.class)).Eco;
        if (localObject1 != null) {
          break label1695;
        }
        localObject1 = null;
        label895:
        Log.i((String)localObject3, localObject1);
        label1047:
        if (localObject2 != null)
        {
          localObject1 = ((f)business(f.class)).mZr;
          if (localObject1 != null) {
            break label1741;
          }
          localObject1 = null;
          label938:
          if (Util.isEqual((String)localObject2, (String)localObject1))
          {
            localObject1 = e.a.mKb;
            bool = com.tencent.mm.ae.d.ee(i, e.a.bcs());
            if (this.CuN != bool)
            {
              qn(bool);
              if (!bool) {
                break label1751;
              }
              localObject1 = this.CuL;
              if (localObject1 != null) {
                ((aw)localObject1).qK(true);
              }
              qm(false);
              localObject1 = new Bundle();
              ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
              localObject3 = this.CuL;
              if (localObject3 != null) {
                ((aw)localObject3).statusChange(b.c.neR, (Bundle)localObject1);
              }
              localObject1 = this.CuL;
              if (localObject1 != null) {
                ((aw)localObject1).Y(this.CuM, this.CuN);
              }
            }
            localObject1 = ((e)business(e.class)).Eco;
            if (localObject1 != null) {
              break label1778;
            }
            localObject1 = null;
            label1096:
            localObject3 = (CharSequence)localObject1;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label1824;
            }
            paramInt = 1;
            label1120:
            if (paramInt == 0) {
              break label2722;
            }
            localObject1 = ((e)business(e.class)).Eco;
            if (localObject1 != null) {
              break label1829;
            }
            localObject1 = "";
          }
        }
      }
    }
    label1695:
    label1824:
    label1952:
    label2722:
    for (;;)
    {
      label1148:
      localObject3 = e.a.mKb;
      bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
      if (this.CuM != bool)
      {
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1915;
        }
        paramInt = 1;
        label1195:
        if (paramInt == 0)
        {
          qm(bool);
          localObject1 = e.a.mKb;
          bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
          if (!bool) {
            break label1920;
          }
          localObject1 = this.CuL;
          if (localObject1 != null) {
            ((aw)localObject1).bev();
          }
          label1242:
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", bool);
          ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", this.CuN);
          localObject3 = this.CuL;
          if (localObject3 != null) {
            ((aw)localObject3).statusChange(b.c.neR, (Bundle)localObject1);
          }
          localObject1 = this.CuL;
          if (localObject1 != null) {
            ((aw)localObject1).Y(this.CuM, this.CuN);
          }
        }
      }
      localObject1 = this.CuL;
      if (localObject1 != null)
      {
        localObject3 = e.a.mKb;
        if (!com.tencent.mm.ae.d.ee(i, e.a.bcq()))
        {
          bool = true;
          label1351:
          ((aw)localObject1).qJ(bool);
        }
      }
      else
      {
        localObject1 = ((j)business(j.class)).Efv;
        if (localObject1 != null) {
          if (Util.isEqual(((h)localObject1).mXL, (String)localObject2))
          {
            localObject3 = e.a.mKb;
            bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
            if (((h)localObject1).AWE != bool)
            {
              localObject3 = (CharSequence)((h)localObject1).EbH;
              if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                break label1947;
              }
            }
          }
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0)
        {
          ((h)localObject1).AWE = bool;
          localObject3 = this.CuL;
          if (localObject3 != null)
          {
            ((aw)localObject3).awC(((h)localObject1).mXL);
            localObject3 = ah.aiuX;
          }
          localObject3 = this.CuL;
          if (localObject3 != null)
          {
            ((aw)localObject3).emx();
            localObject3 = ah.aiuX;
          }
        }
        localObject3 = e.a.mKb;
        bool = com.tencent.mm.ae.d.ee(i, e.a.bcq());
        if (((h)localObject1).EbG != bool)
        {
          ((h)localObject1).EbG = bool;
          localObject1 = this.CuL;
          if (localObject1 != null)
          {
            ((aw)localObject1).emy();
            localObject1 = ah.aiuX;
          }
        }
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        if (!((String)localObject2).equals(((f)business(f.class)).mZr.aaOw)) {
          break label2192;
        }
        paramBundle = paramBundle.getString("live_link_mic_info_in_anchor_sei_msg");
        if (!Util.isNullOrNil(paramBundle)) {
          break label2206;
        }
        if (((j)business(j.class)).EfM) {
          break label1952;
        }
        AppMethodBeat.o(351018);
        return;
        localObject1 = paramBundle.getString("live_cdn_sei_msg");
        break;
        label1640:
        break label618;
        label1643:
        Log.d(getTAG(), "anchorId is invalid, maybe is in pk link mic. " + localObject2 + ' ' + ((f)business(f.class)).mZr.aaOw);
        break label762;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label895;
        }
        localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label895;
        }
        localObject1 = ((bgk)localObject1).EcY;
        break label895;
        label1741:
        localObject1 = ((dix)localObject1).aaOw;
        break label938;
        label1751:
        localObject1 = this.CuL;
        if (localObject1 != null) {
          ((aw)localObject1).qK(false);
        }
        qm(false);
        break label1047;
        label1778:
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label1096;
        }
        localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label1096;
        }
        localObject1 = ((bgk)localObject1).EcY;
        break label1096;
        paramInt = 0;
        break label1120;
        label1829:
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label1148;
        }
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label1148;
        }
        localObject1 = (FinderMedia)p.oL((List)localObject1);
        if (localObject1 == null)
        {
          localObject1 = "";
          break label1148;
        }
        localObject3 = ((FinderMedia)localObject1).url;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label1148;
        }
        localObject1 = "";
        break label1148;
        label1915:
        paramInt = 0;
        break label1195;
        localObject1 = this.CuL;
        if (localObject1 == null) {
          break label1242;
        }
        ((aw)localObject1).bew();
        break label1242;
        bool = false;
        break label1351;
      }
      Log.i(getTAG(), "EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: linkMicInfo empty, linkMicInfo:" + paramBundle + ", roomPk:" + ((j)business(j.class)).EfM);
      localObject1 = new JSONObject();
      Log.i(getTAG(), s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: micData:", localObject1));
      ??? = ((JSONObject)localObject1).optJSONArray("list");
      if (??? == null)
      {
        paramInt = 0;
        label2038:
        if (paramInt != 0) {
          break label2266;
        }
        ((j)business(j.class)).EfM = false;
        ((j)business(j.class)).Efv = null;
        ((j)business(j.class)).ezc();
        paramBundle = ((j)business(j.class)).Efw;
        s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        if (((Collection)paramBundle).isEmpty()) {
          break label2242;
        }
        paramInt = 1;
        label2114:
        if (paramInt == 0) {
          break label2247;
        }
        paramBundle = getTAG();
        localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i(paramBundle, s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: audienceLinkMicUserList:", com.tencent.mm.plugin.finder.live.view.convert.a.gM(((j)business(j.class)).Efw)));
        paramBundle = this.CuL;
        if (paramBundle != null)
        {
          paramBundle.setLastRoomPkMicUserList(null);
          paramBundle = ah.aiuX;
        }
        paramBundle = this.CuL;
        if (paramBundle != null)
        {
          aw.a.a(paramBundle, false, 2);
          paramBundle = ah.aiuX;
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramBundle = ah.aiuX;
          paramBundle = ah.aiuX;
          AppMethodBeat.o(351018);
          return;
          try
          {
            paramBundle = new JSONObject(paramBundle);
            localObject1 = paramBundle;
          }
          catch (JSONException paramBundle)
          {
            for (;;)
            {
              paramBundle = new JSONObject();
            }
          }
        }
        paramInt = ((JSONArray)???).length();
        break label2038;
        label2242:
        paramInt = 0;
        break label2114;
        label2247:
        paramBundle = this.CuL;
        if (paramBundle != null) {
          aw.a.a(paramBundle, (JSONObject)localObject1);
        }
      }
      label2266:
      ((j)business(j.class)).EfM = true;
      paramBundle = this.CuL;
      if (paramBundle != null)
      {
        aw.a.a(paramBundle, b.c.neC);
        paramBundle = ah.aiuX;
      }
      paramInt = 1;
      localObject5 = new LinkedList();
      j = 0;
      int k;
      if (??? == null)
      {
        i = 0;
        if (i <= 0) {
          break label2717;
        }
        paramBundle = null;
        paramInt = 1;
        k = j + 1;
        if (??? != null) {
          break label2564;
        }
        localObject2 = null;
        label2342:
        if (localObject2 != null) {
          break label2576;
        }
        localObject3 = null;
        label2350:
        localObject4 = ((j)business(j.class)).Efx;
        s.s(localObject4, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
      }
      for (;;)
      {
        synchronized ((Iterable)localObject4)
        {
          Iterator localIterator = ((Iterable)???).iterator();
          if (localIterator.hasNext())
          {
            localObject4 = localIterator.next();
            bool = Util.isEqual(((h)localObject4).mXL, (String)localObject3);
            if (!bool) {
              continue;
            }
            localObject4 = (h)localObject4;
            if (localObject4 != null) {
              break label2606;
            }
            Log.i(getTAG(), s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: can't find user info, userId:", localObject3));
            paramInt = 0;
            if (k < i) {
              break label2710;
            }
            ehm();
            if (paramInt == 0) {
              break;
            }
            ((j)business(j.class)).Efv = paramBundle;
            ((j)business(j.class)).Efw.clear();
            paramBundle = ((Iterable)localObject5).iterator();
            if (!paramBundle.hasNext()) {
              break label2691;
            }
            localObject2 = (h)paramBundle.next();
            ((e)business(e.class)).g((h)localObject2);
            continue;
            i = ((JSONArray)???).length();
            break label2320;
            localObject2 = ((JSONArray)???).optJSONObject(j);
            break label2342;
            localObject3 = ((JSONObject)localObject2).optString("uId");
            break label2350;
          }
          localObject4 = null;
        }
        label2606:
        if (localObject2 == null) {}
        for (j = 0;; j = ((JSONObject)localObject2).optInt("us"))
        {
          localObject2 = e.m.mLr;
          ((h)localObject4).EbG = com.tencent.mm.ae.d.ee(j, e.m.bdw());
          if (!((h)localObject4).EbD) {
            break label2659;
          }
          paramBundle = (Bundle)localObject4;
          break;
        }
        label2659:
        localObject2 = e.m.mLr;
        ((h)localObject4).EbK = Boolean.valueOf(com.tencent.mm.ae.d.ee(j, e.m.bdz()));
        ((LinkedList)localObject5).add(localObject4);
        continue;
        paramBundle = this.CuL;
        if (paramBundle == null) {
          break;
        }
        aw.a.a(paramBundle, (JSONObject)localObject1);
        break;
        j = k;
        break label2328;
        paramBundle = null;
      }
    }
  }
  
  public final void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(350975);
    if (this.CuM != paramBoolean) {
      Log.i(getTAG(), s.X("set lastAudioMode:", Boolean.valueOf(paramBoolean)));
    }
    this.CuM = paramBoolean;
    AppMethodBeat.o(350975);
  }
  
  public final void qn(boolean paramBoolean)
  {
    AppMethodBeat.i(350983);
    if (this.CuN != paramBoolean) {
      Log.i(getTAG(), s.X("set lastScreenShareMode:", Boolean.valueOf(paramBoolean)));
    }
    this.CuN = paramBoolean;
    AppMethodBeat.o(350983);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ah.a parama, dlg paramdlg, a parama1, LinkedList<h> paramLinkedList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.business.a
 * JD-Core Version:    0.7.0.1
 */