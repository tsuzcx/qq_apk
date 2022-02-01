package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.plugin.finder.cgi.g;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.FinderLiveAnchorMicFeedView;
import com.tencent.mm.plugin.findersdk.a.ao;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.g.c;
import com.tencent.threadpool.h;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedDecorator;", "scene", "", "decorateView", "Landroid/view/ViewGroup;", "audioModeSwitchCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAudioMode", "", "(ILandroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "anchorData", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator$AnchorData;", "enable", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isFetching", "isRoomPk", "micMode", "micUserCache", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator$MicUserInfo;", "Lkotlin/collections/HashMap;", "micUserList", "", "kotlin.jvm.PlatformType", "", "onLinkMicCallback", "getOnLinkMicCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLinkMicCallback", "(Lkotlin/jvm/functions/Function1;)V", "pkAnchorData", "checkAnchorViewWhenAudioMode", "isPkAnchor", "checkDecorateInfoNew", "msgType", "dSeiMsg", "mSeiMsg", "checkLinkMicMode", "videoW", "videoH", "diffMicSei", "newMicList", "getOtherRoomUserList", "excludeAnchor", "getSelfRoomUserList", "handleAnchorSei", "seiMsg", "handleMicSei", "handleMicSeiNew", "handleSeiMessage", "seiData", "", "onVideoPlayBegin", "resetSeiData", "setFeedData", "setLinkMicCallback", "newCallback", "tryFetchMicUserInfo", "tryFetchMicUserInfoResp", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "updateMicView", "AnchorData", "Companion", "MicUserInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements ao
{
  private static final int AWD;
  public static final aa.b AWs;
  private FeedData AWA;
  private boolean AWB;
  public kotlin.g.a.b<? super List<String>, ah> AWC;
  private final ViewGroup AWt;
  private boolean AWu;
  private boolean AWv;
  private aa.a AWw;
  private aa.a AWx;
  private List<String> AWy;
  private HashMap<String, aa.c> AWz;
  private kotlin.g.a.b<? super Boolean, ah> DWS;
  private boolean enable;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(363376);
    AWs = new aa.b((byte)0);
    AWD = 1;
    AppMethodBeat.o(363376);
  }
  
  public aa(int paramInt, ViewGroup paramViewGroup, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(370840);
    this.scene = paramInt;
    this.AWt = paramViewGroup;
    this.DWS = paramb;
    this.AWw = new aa.a();
    this.AWx = new aa.a();
    this.AWy = Collections.synchronizedList((List)new ArrayList());
    this.AWz = new HashMap();
    this.enable = true;
    paramViewGroup = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWQ().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.enable = bool;
      Log.i("FinderLiveFeedDecorator", s.X("feedDecorate enable:", Boolean.valueOf(this.enable)));
      AppMethodBeat.o(370840);
      return;
    }
  }
  
  private final void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(363175);
    Object localObject1;
    Object localObject3;
    boolean bool1;
    if (paramString1 != null) {
      if (com.tencent.mm.ae.d.ee(paramInt, e.q.mLM.value))
      {
        if (paramString1 != null)
        {
          ??? = new com.tencent.mm.ad.i(paramString1);
          localObject1 = e.r.mLO;
          localObject1 = ((com.tencent.mm.ad.i)???).optString(e.r.getUserId());
          if (localObject1 != null) {
            break label555;
          }
          localObject1 = "";
          localObject3 = e.r.mLO;
          paramInt = ((com.tencent.mm.ad.i)???).optInt(e.r.bdI());
          ??? = e.a.mKb;
          bool1 = com.tencent.mm.ae.d.ee(paramInt, e.a.bcr());
          ??? = (CharSequence)this.AWw.mXL;
          if ((??? != null) && (((CharSequence)???).length() != 0)) {
            break label558;
          }
          paramInt = 1;
          label118:
          if (paramInt == 0)
          {
            if (!Util.isEqual(this.AWw.mXL, (String)localObject1)) {
              break label563;
            }
            if (this.AWw.AWE != bool1)
            {
              this.AWw.AWE = bool1;
              ecm();
            }
          }
        }
        label162:
        if ((paramString1 == null) || (paramString2 == null)) {
          break label768;
        }
        localObject1 = (CharSequence)this.AWw.mXL;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          paramInt = 1;
          label199:
          if ((paramInt != 0) || (!this.AWu)) {
            break label737;
          }
        }
      }
    }
    for (;;)
    {
      label294:
      label334:
      label368:
      int i;
      try
      {
        for (;;)
        {
          paramString1 = new com.tencent.mm.ad.i(paramString1);
          localObject1 = e.r.mLO;
          localObject1 = paramString1.optString(e.r.getUserId());
          paramString1 = (String)localObject1;
          if (localObject1 == null) {
            paramString1 = "";
          }
          if (Util.isEqual(paramString1, this.AWw.mXL))
          {
            paramString1 = new com.tencent.mm.ad.i(paramString2);
            localObject1 = new ArrayList();
            paramString2 = paramString1.Fr("list");
            if (paramString2 == null)
            {
              paramInt = 0;
              break label788;
              if (paramString1 == null) {
                break label810;
              }
              paramString1 = paramString1.optString("uId");
              if ((paramString1 == null) || (Util.isEqual(paramString1, this.AWx.mXL))) {
                break label810;
              }
              ((ArrayList)localObject1).add(paramString1);
              break label810;
              bool1 = ga((List)localObject1);
              if (bool1)
              {
                this.AWy.clear();
                if (paramString2 != null) {
                  break label707;
                }
                paramInt = 0;
                break label819;
                if (paramString1 == null) {
                  break label841;
                }
                localObject1 = paramString1.optString("uId");
                if (localObject1 == null) {
                  break label841;
                }
                paramString1 = this.AWy;
                s.s(paramString1, "micUserList");
              }
            }
            synchronized ((Iterable)paramString1)
            {
              localObject3 = ((Iterable)???).iterator();
              boolean bool2;
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                paramString1 = ((Iterator)localObject3).next();
                bool2 = Util.isEqual((String)paramString1, (String)localObject1);
              } while (!bool2);
              if ((paramString1 != null) || (Util.isEqual((String)localObject1, this.AWx.mXL))) {
                break label841;
              }
              this.AWy.add(localObject1);
              break label841;
              label487:
              paramString1 = this.AWC;
              if (paramString1 != null)
              {
                paramString2 = new LinkedList();
                paramString2.addAll((Collection)this.AWy);
                localObject1 = ah.aiuX;
                paramString1.invoke(paramString2);
              }
              ecp();
              Log.d("FinderLiveFeedDecorator", s.X("handleMicSei diffMicSei:", Boolean.valueOf(bool1)));
              AppMethodBeat.o(363175);
              return;
              label555:
              break;
              label558:
              paramInt = 0;
              break label118;
              label563:
              ??? = (CharSequence)this.AWx.mXL;
              if ((??? == null) || (((CharSequence)???).length() == 0)) {}
              for (paramInt = 1; paramInt == 0; paramInt = 0)
              {
                if ((!Util.isEqual(this.AWx.mXL, (String)localObject1)) || (this.AWx.AWE == bool1)) {
                  break label644;
                }
                this.AWx.AWE = bool1;
                ecm();
                break;
              }
              label644:
              if (Util.isEqual(this.AWx.mXL, (String)localObject1)) {
                break label162;
              }
              this.AWx.avP((String)localObject1);
              this.AWx.AWE = bool1;
              ecp();
              break label162;
              paramInt = 0;
              break label199;
              paramInt = paramString2.length();
              break label788;
              label697:
              paramString1 = paramString2.su(i);
              break label294;
              label707:
              paramInt = paramString2.length();
              break label819;
              label715:
              paramString1 = paramString2.su(i);
            }
          }
        }
        AppMethodBeat.o(363175);
      }
      catch (Exception paramString1) {}
      label737:
      return;
      if ((com.tencent.mm.ae.d.ee(paramInt, e.q.mLK.value)) && (!this.AWB)) {
        avO(paramString1);
      }
      label768:
      AppMethodBeat.o(363175);
      return;
      int j;
      label788:
      label795:
      label810:
      label819:
      label826:
      label841:
      do
      {
        i = j;
        break label826;
        do
        {
          i = j;
          break label795;
          if (paramInt <= 0) {
            break label334;
          }
          i = 0;
          j = i + 1;
          if (paramString2 != null) {
            break label697;
          }
          paramString1 = null;
          break;
        } while (j < paramInt);
        break label334;
        if (paramInt <= 0) {
          break label487;
        }
        i = 0;
        j = i + 1;
        if (paramString2 != null) {
          break label715;
        }
        paramString1 = null;
        break label368;
      } while (j < paramInt);
      continue;
      paramString1 = null;
    }
  }
  
  private final void a(aa.a parama, boolean paramBoolean)
  {
    bgh localbgh = null;
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(363227);
    ViewGroup localViewGroup = this.AWt;
    Object localObject1;
    label72:
    Object localObject2;
    if (localViewGroup != null)
    {
      localObject1 = this.AWA;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1466;
        }
        Log.i("FinderLiveFeedDecorator", "coverUrl is null, try thumbUrl");
        localObject1 = this.AWA;
        if (localObject1 != null) {
          break label330;
        }
        localObject1 = "";
        localObject2 = this.AWA;
        if (localObject2 != null) {
          break label399;
        }
        localObject2 = "";
        label88:
        localObject1 = s.X((String)localObject1, localObject2);
      }
    }
    label399:
    label1466:
    for (;;)
    {
      if (!paramBoolean)
      {
        localObject2 = this.DWS;
        if (localObject2 != null) {
          ((kotlin.g.a.b)localObject2).invoke(Boolean.valueOf(parama.AWE));
        }
      }
      if (parama.AWE)
      {
        if (paramBoolean)
        {
          if (this.AWB)
          {
            if (eco().isEmpty())
            {
              localObject1 = localViewGroup.getContext();
              s.s(localObject1, "it.context");
              localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject1);
              localObject1 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
              localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
              localObject1 = (aa.c)this.AWz.get(parama.mXL);
              if (localObject1 == null) {
                localObject1 = localObject3;
              }
              for (;;)
              {
                ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
                ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(localViewGroup.getMeasuredWidth() / 2.0F);
                ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
                AppMethodBeat.o(363227);
                return;
                localObject1 = ((FeedData)localObject1).getMediaList();
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break;
                }
                localObject1 = (dji)p.oL((List)localObject1);
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break;
                }
                localObject1 = ((dji)localObject1).coverUrl;
                break;
                label330:
                localObject1 = ((FeedData)localObject1).getMediaList();
                if (localObject1 == null)
                {
                  localObject1 = "";
                  break label72;
                }
                localObject1 = (dji)p.oL((List)localObject1);
                if (localObject1 == null)
                {
                  localObject1 = "";
                  break label72;
                }
                localObject1 = ((dji)localObject1).thumbUrl;
                if (localObject1 == null)
                {
                  localObject1 = "";
                  break label72;
                }
                break label72;
                localObject2 = ((FeedData)localObject2).getMediaList();
                if (localObject2 == null)
                {
                  localObject2 = "";
                  break label88;
                }
                localObject2 = (dji)p.oL((List)localObject2);
                if (localObject2 == null)
                {
                  localObject2 = "";
                  break label88;
                }
                String str = ((dji)localObject2).thumb_url_token;
                localObject2 = str;
                if (str != null) {
                  break label88;
                }
                localObject2 = "";
                break label88;
                localbgh = ((aa.c)localObject1).AWF;
                localObject1 = localObject3;
                if (localbgh != null) {
                  localObject1 = localbgh.ZOx;
                }
              }
            }
            localObject1 = localViewGroup.getContext();
            s.s(localObject1, "it.context");
            localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject1);
            localObject1 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight() / 2);
            localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            localObject1 = (aa.c)this.AWz.get(parama.mXL);
            if (localObject1 == null) {
              localObject1 = localbgh;
            }
            for (;;)
            {
              ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
              ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(localViewGroup.getMeasuredWidth() / 2.0F);
              ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
              AppMethodBeat.o(363227);
              return;
              localObject3 = ((aa.c)localObject1).AWF;
              localObject1 = localbgh;
              if (localObject3 != null) {
                localObject1 = ((bgh)localObject3).ZOx;
              }
            }
          }
          localObject1 = localViewGroup.getContext();
          s.s(localObject1, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject1);
          localObject1 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          localObject1 = (aa.c)this.AWz.get(parama.mXL);
          if (localObject1 == null) {
            localObject1 = localObject4;
          }
          for (;;)
          {
            ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
            ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(localViewGroup.getMeasuredWidth() / 2.0F);
            ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
            AppMethodBeat.o(363227);
            return;
            localObject3 = ((aa.c)localObject1).AWF;
            localObject1 = localObject4;
            if (localObject3 != null) {
              localObject1 = ((bgh)localObject3).ZOx;
            }
          }
        }
        if (this.AWB)
        {
          if (this.AWy.size() != 0)
          {
            if (ecn().isEmpty())
            {
              localObject2 = localViewGroup.getContext();
              s.s(localObject2, "it.context");
              localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
              localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
              localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
              ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
              ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
              ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
              AppMethodBeat.o(363227);
              return;
            }
            localObject2 = localViewGroup.getContext();
            s.s(localObject2, "it.context");
            localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
            localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight() / 2);
            localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
            ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
            ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
            AppMethodBeat.o(363227);
            return;
          }
          localObject2 = localViewGroup.getContext();
          s.s(localObject2, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
          AppMethodBeat.o(363227);
          return;
        }
        int i = this.AWy.size();
        if (i > 0) {
          if (i <= 2)
          {
            i = 1;
            if (i == 0)
            {
              localObject2 = (CharSequence)this.AWx.mXL;
              if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                break label1266;
              }
            }
          }
        }
        label1266:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1271;
          }
          localObject2 = localViewGroup.getContext();
          s.s(localObject2, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
          ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
          AppMethodBeat.o(363227);
          return;
          i = 0;
          break;
          i = 0;
          break;
        }
        label1271:
        if (this.AWy.size() == 3)
        {
          localObject2 = localViewGroup.getContext();
          s.s(localObject2, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight() / 2);
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
          ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
          AppMethodBeat.o(363227);
          return;
        }
        localObject2 = localViewGroup.getContext();
        s.s(localObject2, "it.context");
        localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
        localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((FinderLiveAnchorMicFeedView)localObject2).aCl((String)localObject1);
        ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.mXL);
      }
      AppMethodBeat.o(363227);
      return;
    }
  }
  
  private static final void a(byte[] paramArrayOfByte, aa paramaa)
  {
    AppMethodBeat.i(363294);
    s.u(paramaa, "this$0");
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = null;
      Log.d("FinderLiveFeedDecorator", "handleSeiMessage seiData:" + paramArrayOfByte + " seiMessage:" + localObject);
      if ((localObject == null) || (n.i((CharSequence)localObject, (CharSequence)"TencentStreamSEI") != true)) {
        break label100;
      }
    }
    label100:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      AppMethodBeat.o(363294);
      return;
      localObject = new String(paramArrayOfByte, kotlin.n.d.UTF_8);
      break;
    }
    label105:
    if (localObject != null) {
      try
      {
        paramArrayOfByte = new com.tencent.mm.ad.i((String)localObject);
        i = paramArrayOfByte.optInt("wxT");
        if ((i != 0) && (!Util.isNullOrNil(paramArrayOfByte.optString("d"))))
        {
          paramaa.A(i, paramArrayOfByte.optString("d"), paramArrayOfByte.optString("m"));
          AppMethodBeat.o(363294);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.w("FinderLiveFeedDecorator", s.X("ex:", paramArrayOfByte.getMessage()));
      }
    }
    AppMethodBeat.o(363294);
  }
  
  private final void avO(String paramString)
  {
    AppMethodBeat.i(363196);
    Object localObject1 = (CharSequence)this.AWw.mXL;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if ((i == 0) && (this.AWu))
      {
        localObject1 = new dlg();
        Object localObject2 = (com.tencent.mm.bx.a)localObject1;
        ??? = kotlin.n.d.UTF_8;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(363196);
          throw paramString;
          i = 0;
        }
        else
        {
          paramString = paramString.getBytes((Charset)???);
          s.s(paramString, "(this as java.lang.String).getBytes(charset)");
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom(paramString);
            localObject2 = new ArrayList();
            paramString = ((dlg)localObject1).ToF;
            if (paramString != null)
            {
              paramString = ((Iterable)paramString).iterator();
              while (paramString.hasNext())
              {
                ??? = ((dlh)paramString.next()).YRR;
                if (??? != null) {
                  ((ArrayList)localObject2).add(???);
                }
              }
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramString });
            }
            boolean bool1;
            for (;;)
            {
              Iterator localIterator;
              synchronized ((Iterable)localObject2)
              {
                localIterator = ((Iterable)???).iterator();
                if (localIterator.hasNext())
                {
                  paramString = localIterator.next();
                  bool1 = Util.isEqual((String)paramString, this.AWw.mXL);
                  if (!bool1) {
                    continue;
                  }
                  if (paramString != null) {
                    break label570;
                  }
                  Log.d("FinderLiveFeedDecorator", "micUserList.size:" + this.AWy.size() + " newMicList.size:" + ((ArrayList)localObject2).size());
                  bool1 = ga((List)localObject2);
                  if (!bool1) {
                    break label555;
                  }
                  this.AWy.clear();
                  paramString = ((dlg)localObject1).ToF;
                  if (paramString == null) {
                    break;
                  }
                  localObject1 = ((Iterable)paramString).iterator();
                  label356:
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = ((dlh)((Iterator)localObject1).next()).YRR;
                  if (localObject2 == null) {
                    continue;
                  }
                  paramString = this.AWy;
                  s.s(paramString, "micUserList");
                }
              }
              synchronized ((Iterable)paramString)
              {
                localIterator = ((Iterable)???).iterator();
                for (;;)
                {
                  if (localIterator.hasNext())
                  {
                    paramString = localIterator.next();
                    boolean bool2 = Util.isEqual((String)paramString, (String)localObject2);
                    if (bool2)
                    {
                      if (paramString != null) {
                        break label356;
                      }
                      this.AWy.add(localObject2);
                      break label356;
                      paramString = null;
                      break;
                      paramString = finally;
                      AppMethodBeat.o(363196);
                      throw paramString;
                    }
                  }
                }
                paramString = null;
              }
            }
            paramString = this.AWC;
            if (paramString != null)
            {
              localObject1 = new LinkedList();
              ((LinkedList)localObject1).addAll((Collection)this.AWy);
              localObject2 = ah.aiuX;
              paramString.invoke(localObject1);
            }
            ecp();
            label555:
            Log.d("FinderLiveFeedDecorator", s.X("handleMicSei diffMicSei:", Boolean.valueOf(bool1)));
          }
        }
      }
    }
    label570:
    AppMethodBeat.o(363196);
  }
  
  private final void ecm()
  {
    AppMethodBeat.i(363240);
    Log.i("FinderLiveFeedDecorator", s.X("updateMicView micUserList.size:", Integer.valueOf(this.AWy.size())));
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(363240);
  }
  
  private final List<String> ecn()
  {
    AppMethodBeat.i(363249);
    ArrayList localArrayList = new ArrayList();
    ??? = this.AWy;
    s.s(???, "micUserList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Iterator localIterator1 = ((Iterable)???).iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = (String)localIterator1.next();
        synchronized ((Map)this.AWz)
        {
          Iterator localIterator2 = ((Map)???).entrySet().iterator();
          if (!localIterator2.hasNext()) {
            break label199;
          }
          Object localObject6 = (Map.Entry)localIterator2.next();
          if (!Util.isEqual((String)((Map.Entry)localObject6).getKey(), (String)localObject5)) {
            continue;
          }
          localObject6 = (aa.c)((Map.Entry)localObject6).getValue();
          if ((localObject6 != null) && (((aa.c)localObject6).AWG == true))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localArrayList.add(localObject5);
          }
        }
      }
      int i = 0;
      continue;
      label199:
      Object localObject5 = ah.aiuX;
    }
    ??? = ah.aiuX;
    p.e((List)localObject3, (kotlin.g.a.b)new aa.e(this));
    ??? = (List)localObject3;
    AppMethodBeat.o(363249);
    return ???;
  }
  
  private final List<String> eco()
  {
    AppMethodBeat.i(363260);
    ArrayList localArrayList = new ArrayList();
    ??? = this.AWy;
    s.s(???, "micUserList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Iterator localIterator1 = ((Iterable)???).iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = (String)localIterator1.next();
        synchronized ((Map)this.AWz)
        {
          Iterator localIterator2 = ((Map)???).entrySet().iterator();
          if (!localIterator2.hasNext()) {
            break label199;
          }
          Object localObject6 = (Map.Entry)localIterator2.next();
          if (!Util.isEqual((String)((Map.Entry)localObject6).getKey(), (String)localObject5)) {
            continue;
          }
          localObject6 = (aa.c)((Map.Entry)localObject6).getValue();
          if ((localObject6 != null) && (((aa.c)localObject6).AWG == true))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localArrayList.add(localObject5);
          }
        }
      }
      int i = 0;
      continue;
      label199:
      Object localObject5 = ah.aiuX;
    }
    ??? = ah.aiuX;
    p.e((List)localObject3, (kotlin.g.a.b)new aa.d(this));
    ??? = (List)localObject3;
    AppMethodBeat.o(363260);
    return ???;
  }
  
  private final void ecp()
  {
    AppMethodBeat.i(363282);
    if (this.AWv)
    {
      Log.i("FinderLiveFeedDecorator", "isFetching, skip!");
      AppMethodBeat.o(363282);
      return;
    }
    this.AWv = true;
    WeakReference localWeakReference = new WeakReference(new aa.h(this));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.AWA;
    long l;
    label83:
    Object localObject2;
    if (localObject1 == null)
    {
      l = 0L;
      localObject1 = this.AWA;
      if (localObject1 != null) {
        break label199;
      }
      localObject1 = "";
      localArrayList.add(new r(Long.valueOf(l), localObject1));
      localObject1 = ah.aiuX;
      localObject2 = com.tencent.mm.ae.d.b((c)new g((List)localArrayList, 3, null, null, 28).bFJ(), (kotlin.g.a.b)new aa.f(localWeakReference));
      localObject1 = this.AWt;
      if (localObject1 != null) {
        break label220;
      }
      localObject1 = null;
      label156:
      if (!(localObject1 instanceof MMActivity)) {
        break label228;
      }
    }
    label199:
    label220:
    label228:
    for (localObject1 = (MMActivity)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((c)localObject2).b((com.tencent.mm.vending.e.b)localObject1);
      }
      AppMethodBeat.o(363282);
      return;
      l = ((FeedData)localObject1).getFeedId();
      break;
      localObject2 = ((FeedData)localObject1).getNonceId();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label83;
      }
      localObject1 = "";
      break label83;
      localObject1 = ((ViewGroup)localObject1).getContext();
      break label156;
    }
  }
  
  private final boolean ga(List<String> paramList)
  {
    AppMethodBeat.i(363208);
    if (this.AWy.isEmpty())
    {
      if (!((Collection)paramList).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(363208);
        return true;
      }
    }
    Object localObject1 = this.AWy;
    s.s(localObject1, "micUserList");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (i != 0) && (paramList.isEmpty()); i = 0)
    {
      AppMethodBeat.o(363208);
      return true;
    }
    localObject1 = new StringBuilder();
    ??? = this.AWy;
    s.s(???, "micUserList");
    synchronized ((Iterable)???)
    {
      localObject3 = ((Iterable)???).iterator();
      if (((Iterator)localObject3).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject3).next());
      }
    }
    Object localObject3 = ah.aiuX;
    ??? = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      ((StringBuilder)???).append((String)paramList.next());
    }
    Log.d("FinderLiveFeedDecorator", "localStr:" + localObject1 + " remoteStr:" + ???);
    if (!Util.isEqual(((StringBuilder)localObject1).toString(), ((StringBuilder)???).toString()))
    {
      AppMethodBeat.o(363208);
      return true;
    }
    AppMethodBeat.o(363208);
    return false;
  }
  
  public final void a(FeedData paramFeedData)
  {
    if (!this.enable) {
      return;
    }
    this.AWA = paramFeedData;
  }
  
  public final void aj(kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    this.AWC = paramb;
  }
  
  public final void bT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(363403);
    if (!this.enable)
    {
      AppMethodBeat.o(363403);
      return;
    }
    CharSequence localCharSequence = (CharSequence)this.AWw.mXL;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(363403);
      return;
    }
    h.ahAA.g(new aa..ExternalSyntheticLambda0(paramArrayOfByte, this), "Sei_Message_Handler");
    AppMethodBeat.o(363403);
  }
  
  public final void eck()
  {
    AppMethodBeat.i(363394);
    if (!this.enable)
    {
      AppMethodBeat.o(363394);
      return;
    }
    this.AWv = false;
    this.AWw = new aa.a();
    this.AWx = new aa.a();
    this.AWy.clear();
    this.AWz.clear();
    ViewGroup localViewGroup = this.AWt;
    if (localViewGroup != null) {
      localViewGroup.removeAllViews();
    }
    this.AWu = false;
    this.AWC = null;
    this.AWB = false;
    AppMethodBeat.o(363394);
  }
  
  public final void ecl()
  {
    AppMethodBeat.i(363415);
    if (!this.enable)
    {
      AppMethodBeat.o(363415);
      return;
    }
    this.AWv = false;
    this.AWw = new aa.a();
    this.AWx = new aa.a();
    this.AWy.clear();
    this.AWz.clear();
    this.AWu = false;
    AppMethodBeat.o(363415);
  }
  
  public final void hu(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(363411);
    if (!this.enable)
    {
      AppMethodBeat.o(363411);
      return;
    }
    for (;;)
    {
      float f;
      try
      {
        Log.i("FinderLiveFeedDecorator", "videoW:" + paramInt1 + " videoH:" + paramInt2);
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          continue;
        }
        f = new BigDecimal(paramInt1 / paramInt2).setScale(1, 4).floatValue();
        if (f == 1.1F)
        {
          paramInt1 = 1;
          break label187;
          this.AWu = bool1;
          if (!this.AWu)
          {
            this.AWx = new aa.a();
            this.AWy.clear();
          }
          ecp();
          AppMethodBeat.o(363411);
        }
        else
        {
          paramInt1 = 0;
        }
      }
      catch (Exception localException)
      {
        this.AWu = false;
        Log.w("FinderLiveFeedDecorator", s.X("checkLinkMicMode exception. ", localException.getMessage()));
        AppMethodBeat.o(363411);
        return;
      }
      paramInt1 = 0;
      break label203;
      boolean bool1 = false;
      continue;
      label187:
      bool1 = bool2;
      if (paramInt1 == 0) {
        if (f == 1.0F)
        {
          paramInt1 = 1;
          label203:
          if (paramInt1 != 0) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa
 * JD-Core Version:    0.7.0.1
 */