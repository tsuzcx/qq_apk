package com.tencent.mm.plugin.finder.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/provider/FinderTextStatusProvider;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-finder_release"})
public final class a
  implements m
{
  public static final a zTy;
  
  static
  {
    AppMethodBeat.i(289935);
    zTy = new a((byte)0);
    AppMethodBeat.o(289935);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, com.tencent.mm.plugin.textstatus.proto.d paramd)
  {
    AppMethodBeat.i(289933);
    kotlin.g.b.p.k(paramFrameLayout, "container");
    kotlin.g.b.p.k(paramTextStatusJumpInfo, "jumpInfo");
    kotlin.g.b.p.k(paramd, "pullDownParam");
    Object localObject = Base64.decode(paramTextStatusJumpInfo.busiBuf, 0);
    paramString = new FinderObject();
    paramString.parseFrom((byte[])localObject);
    localObject = paramString.objectDesc;
    if ((localObject != null) && (((FinderObjectDesc)localObject).mediaType == 2))
    {
      paramString = (com.tencent.mm.ui.widget.b)new com.tencent.mm.plugin.finder.view.p(paramFrameLayout, paramTextStatusJumpInfo, paramd, paramString);
      AppMethodBeat.o(289933);
      return paramString;
    }
    paramString = (com.tencent.mm.ui.widget.b)new com.tencent.mm.plugin.finder.view.q(paramFrameLayout, paramTextStatusJumpInfo, paramd, paramString);
    AppMethodBeat.o(289933);
    return paramString;
  }
  
  public final i dDF()
  {
    AppMethodBeat.i(289934);
    i locali = (i)new b();
    AppMethodBeat.o(289934);
    return locali;
  }
  
  public final void release() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/provider/FinderTextStatusProvider$Companion;", "", "()V", "TAG", "", "TAG_INVALID_VIEW", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/provider/FinderTextStatusProvider$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "createRefParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpSource", "getAuthorName", "", "getReportFeedId", "", "getSourceDesc", "isHasCustomPullDown", "isHidePullDownWhenClose", "isHideSourceInfo", "isStatusValid", "loadAvatar", "", "avatarView", "Landroid/widget/ImageView;", "onAttach", "textStatusID", "", "onDetach", "setCustomAuthorView", "container", "Landroid/widget/FrameLayout;", "setCustomSourceView", "setCustomThumbView", "plugin-finder_release"})
  public static final class b
    extends i
  {
    private FinderObject xcx;
    private List<? extends TextStatusJumpInfo> yNX;
    
    private final void i(ImageView paramImageView)
    {
      AppMethodBeat.i(239243);
      Object localObject1 = this.xcx;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).contact;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((FinderContact)localObject1).headUrl;; localObject1 = null)
      {
        Object localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
        localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        AppMethodBeat.o(239243);
        return;
      }
    }
    
    public final boolean d(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(239237);
      kotlin.g.b.p.k(paramFrameLayout, "container");
      Object localObject2;
      int i;
      if (!dOW())
      {
        localObject2 = paramFrameLayout.findViewWithTag("Finder.TextStatusProvider.invalidView");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ad.kS(paramFrameLayout.getContext()).inflate(b.g.finder_text_status_invalid_view, (ViewGroup)paramFrameLayout, false);
          kotlin.g.b.p.j(localObject1, "MMLayoutInflater.getInfl…d_view, container, false)");
          ((View)localObject1).setTag("Finder.TextStatusProvider.invalidView");
          paramFrameLayout.removeAllViews();
          paramFrameLayout.addView((View)localObject1);
        }
        paramFrameLayout = h.aHG();
        kotlin.g.b.p.j(paramFrameLayout, "MMKernel.storage()");
        paramFrameLayout = paramFrameLayout.aHp().get(ar.a.VyV, "");
        if (paramFrameLayout == null)
        {
          paramFrameLayout = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(239237);
          throw paramFrameLayout;
        }
        paramFrameLayout = (String)paramFrameLayout;
        if (((CharSequence)paramFrameLayout).length() == 0)
        {
          i = 1;
          if (i == 0)
          {
            Log.i("Finder.TextStatusProvider", "[checkShowValidLayout] wording=".concat(String.valueOf(paramFrameLayout)));
            localObject2 = (TextView)((View)localObject1).findViewById(b.f.invalid_tv);
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)paramFrameLayout);
            }
          }
          paramFrameLayout = ((View)localObject1).findViewById(b.f.invalid_container);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(0);
          }
          paramFrameLayout = ((View)localObject1).findViewById(b.f.invalid_layout);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(0);
          }
          paramFrameLayout = ((View)localObject1).findViewById(b.f.hint_invalid_layout);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(8);
          }
        }
      }
      Object localObject3;
      do
      {
        AppMethodBeat.o(239237);
        return true;
        i = 0;
        break;
        localObject3 = this.xcx;
      } while (localObject3 == null);
      Object localObject1 = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localObject1 == null)
      {
        localObject1 = new ImageView(paramFrameLayout.getContext());
        ((ImageView)localObject1).setTag("Finder.TextStatusProvider");
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localObject1);
      }
      for (paramFrameLayout = (FrameLayout)localObject1;; paramFrameLayout = (FrameLayout)localObject1)
      {
        paramFrameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject1 = FinderItem.Companion;
        localObject2 = FinderItem.a.b((FinderObject)localObject3, ((FinderObject)localObject3).objectType);
        localObject1 = ((FinderObject)localObject3).objectDesc;
        if ((localObject1 != null) && (((FinderObjectDesc)localObject1).mediaType == 2)) {}
        for (localObject1 = u.Aly;; localObject1 = u.Alz)
        {
          localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject2 = ((FinderItem)localObject2).getMediaList().getFirst();
          kotlin.g.b.p.j(localObject2, "finderItem.mediaList.first");
          localObject1 = new o((csg)localObject2, (u)localObject1);
          localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((com.tencent.mm.loader.f.e)new a(paramFrameLayout)).aRr();
          break;
        }
      }
    }
    
    public final String dDG()
    {
      AppMethodBeat.i(239232);
      Object localObject = this.xcx;
      if (localObject != null) {}
      for (long l = ((FinderObject)localObject).id;; l = 0L)
      {
        localObject = Util.getUnsignedLongString(l);
        kotlin.g.b.p.j(localObject, "Util.getUnsignedLongString(finderObject?.id ?: 0)");
        AppMethodBeat.o(239232);
        return localObject;
      }
    }
    
    public final boolean dDH()
    {
      return true;
    }
    
    public final CharSequence dDJ()
    {
      AppMethodBeat.i(239240);
      if (!dOW())
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(239240);
        return localObject;
      }
      Object localObject = this.xcx;
      if (localObject != null)
      {
        localObject = ((FinderObject)localObject).nickname;
        if (localObject != null)
        {
          localObject = (CharSequence)localObject;
          AppMethodBeat.o(239240);
          return localObject;
        }
      }
      localObject = (CharSequence)"";
      AppMethodBeat.o(239240);
      return localObject;
    }
    
    public final CharSequence dDK()
    {
      AppMethodBeat.i(239242);
      if (!dOW())
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(239242);
        return localObject;
      }
      Object localObject = this.xcx;
      if (localObject != null)
      {
        localObject = ((FinderObject)localObject).objectDesc;
        if (localObject != null)
        {
          localObject = ((FinderObjectDesc)localObject).description;
          if (localObject != null)
          {
            localObject = (CharSequence)localObject;
            AppMethodBeat.o(239242);
            return localObject;
          }
        }
      }
      localObject = (CharSequence)"";
      AppMethodBeat.o(239242);
      return localObject;
    }
    
    public final boolean dDL()
    {
      return true;
    }
    
    public final boolean dOW()
    {
      AppMethodBeat.i(239230);
      Object localObject = com.tencent.mm.plugin.finder.view.a.ATY;
      localObject = this.xcx;
      if (localObject != null) {}
      for (long l = ((FinderObject)localObject).id;; l = 0L)
      {
        boolean bool = com.tencent.mm.plugin.finder.view.a.a.Nt(l);
        AppMethodBeat.o(239230);
        return bool;
      }
    }
    
    public final boolean dOX()
    {
      return false;
    }
    
    public final com.tencent.mm.plugin.textstatus.a.q dOY()
    {
      Object localObject1 = null;
      AppMethodBeat.i(239247);
      FinderObject localFinderObject = this.xcx;
      if (localFinderObject == null)
      {
        AppMethodBeat.o(239247);
        return null;
      }
      Object localObject2 = ac.AEJ;
      localObject2 = localFinderObject.nickname;
      FinderContact localFinderContact = localFinderObject.contact;
      if (localFinderContact != null) {
        localObject1 = localFinderContact.headUrl;
      }
      localObject1 = ac.a.a((String)localObject2, (String)localObject1, localFinderObject.id, localFinderObject);
      AppMethodBeat.o(239247);
      return localObject1;
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(239238);
      kotlin.g.b.p.k(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        i(localImageView);
        AppMethodBeat.o(239238);
        return true;
      }
    }
    
    public final boolean f(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(239239);
      kotlin.g.b.p.k(paramFrameLayout, "container");
      paramFrameLayout.removeAllViews();
      if (!dOW())
      {
        AppMethodBeat.o(239239);
        return false;
      }
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.addView((View)localImageView);
        i(localImageView);
        AppMethodBeat.o(239239);
        return true;
      }
    }
    
    public final boolean fA(Context paramContext)
    {
      Object localObject2 = null;
      AppMethodBeat.i(239244);
      kotlin.g.b.p.k(paramContext, "context");
      Intent localIntent;
      Object localObject1;
      if (this.xcx != null)
      {
        localIntent = new Intent();
        localObject1 = this.xcx;
        if (localObject1 == null) {
          break label147;
        }
        localObject1 = ((FinderObject)localObject1).contact;
        if (localObject1 == null) {
          break label147;
        }
        localObject1 = ((FinderContact)localObject1).username;
        boolean bool = kotlin.g.b.p.h(localObject1, z.bdh());
        Object localObject3 = this.xcx;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObject)localObject3).contact;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((FinderContact)localObject3).username;
          }
        }
        localIntent.putExtra("finder_username", (String)localObject1);
        if (!bool) {
          break label152;
        }
        ((ak)h.ag(ak.class)).enterFinderSelfProfile(paramContext, localIntent, 20, 2);
      }
      for (;;)
      {
        if (this.xcx == null) {
          break label194;
        }
        AppMethodBeat.o(239244);
        return true;
        label147:
        localObject1 = null;
        break;
        label152:
        ((ak)h.ag(ak.class)).fillContextIdToIntent(20, 2, 32, localIntent);
        ((ak)h.ag(ak.class)).enterFinderProfileUI(paramContext, localIntent);
      }
      label194:
      AppMethodBeat.o(239244);
      return false;
    }
    
    public final boolean fz(Context paramContext)
    {
      AppMethodBeat.i(239236);
      Log.i("Finder.TextStatusProvider", "[doJump]");
      Object localObject1 = new FinderObject();
      Object localObject2 = this.yNX;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (TextStatusJumpInfo)((Iterator)localObject2).next();
          if (kotlin.g.b.p.h(((TextStatusJumpInfo)localObject3).jumpType, "5"))
          {
            ((FinderObject)localObject1).parseFrom(Base64.decode(((TextStatusJumpInfo)localObject3).busiBuf, 0));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("feed_object_id", ((FinderObject)localObject1).id);
            ((Intent)localObject2).putExtra("feed_object_nonceId", ((FinderObject)localObject1).objectNonceId);
            ((Intent)localObject2).putExtra("key_need_related_list", false);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("feedId", com.tencent.mm.ae.d.Fw(((FinderObject)localObject1).id));
            localObject1 = ((FinderObject)localObject1).contact;
            if (localObject1 != null) {}
            for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
            {
              ((JSONObject)localObject3).put("finderusername", localObject1);
              ((Intent)localObject2).putExtra("key_extra_info", ((JSONObject)localObject3).toString());
              ((ak)h.ag(ak.class)).fillContextIdToIntent(20, 2, 25, (Intent)localObject2);
              ((ak)h.ag(ak.class)).enterFinderShareFeedUI(paramContext, (Intent)localObject2);
              AppMethodBeat.o(239236);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(239236);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void s(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(239229);
      this.yNX = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext())
        {
          paramList = (TextStatusJumpInfo)paramString.next();
          if (kotlin.g.b.p.h(paramList.jumpType, "5"))
          {
            paramList = Base64.decode(paramList.busiBuf, 0);
            this.xcx = new FinderObject();
            FinderObject localFinderObject = this.xcx;
            if (localFinderObject != null) {
              localFinderObject.parseFrom(paramList);
            }
          }
        }
        AppMethodBeat.o(239229);
        return;
      }
      AppMethodBeat.o(239229);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class a<T, R>
      implements com.tencent.mm.loader.f.e<w, Bitmap>
    {
      a(ImageView paramImageView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.provider.a
 * JD-Core Version:    0.7.0.1
 */