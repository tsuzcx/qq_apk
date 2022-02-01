package com.tencent.mm.plugin.finder.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.view.r;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/provider/FinderTextStatusProvider;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements o
{
  public static final a FhM;
  
  static
  {
    AppMethodBeat.i(329907);
    FhM = new a((byte)0);
    AppMethodBeat.o(329907);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    int j = 0;
    AppMethodBeat.i(329913);
    kotlin.g.b.s.u(paramFrameLayout, "container");
    kotlin.g.b.s.u(paramTextStatusJumpInfo, "jumpInfo");
    kotlin.g.b.s.u(paraml, "pullDownParam");
    Object localObject = Base64.decode(paramTextStatusJumpInfo.busiBuf, 0);
    paramString = new FinderObject();
    paramString.parseFrom((byte[])localObject);
    localObject = paramString.objectDesc;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((FinderObjectDesc)localObject).mediaType == 2) {
        i = 1;
      }
    }
    if (i != 0)
    {
      paramString = (com.tencent.mm.ui.widget.b)new r(paramFrameLayout, paramTextStatusJumpInfo, paraml, paramString);
      AppMethodBeat.o(329913);
      return paramString;
    }
    paramString = (com.tencent.mm.ui.widget.b)new com.tencent.mm.plugin.finder.view.s(paramFrameLayout, paramTextStatusJumpInfo, paraml, paramString);
    AppMethodBeat.o(329913);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.k axF(String paramString)
  {
    AppMethodBeat.i(329916);
    paramString = (com.tencent.mm.plugin.textstatus.a.k)new b(paramString);
    AppMethodBeat.o(329916);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/provider/FinderTextStatusProvider$Companion;", "", "()V", "TAG", "", "TAG_INVALID_VIEW", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/provider/FinderTextStatusProvider$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "createRefParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpSource", "extParam", "Landroid/os/Bundle;", "getAuthorName", "", "getReportFeedId", "", "getSourceDesc", "isHasCustomPullDown", "isHidePullDownWhenClose", "isHideSourceInfo", "isStatusValid", "loadAvatar", "", "avatarView", "Landroid/widget/ImageView;", "onAttach", "textStatusID", "", "onDetach", "setCustomAuthorView", "container", "Landroid/widget/FrameLayout;", "setCustomSourceView", "setCustomThumbView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.textstatus.a.k
  {
    private FinderObject ABJ;
    private List<? extends TextStatusJumpInfo> DHi;
    
    b(String paramString)
    {
      super();
    }
    
    private static final void b(ImageView paramImageView, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(329929);
      kotlin.g.b.s.u(paramImageView, "$thumbView");
      paramImageView.post(new a.b..ExternalSyntheticLambda1(paramBitmap, paramImageView));
      AppMethodBeat.o(329929);
    }
    
    private static final void c(Bitmap paramBitmap, ImageView paramImageView)
    {
      AppMethodBeat.i(329924);
      kotlin.g.b.s.u(paramImageView, "$thumbView");
      com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
      kotlin.g.b.s.s(paramBitmap, "resource");
      locala.setInputBitmap(paramBitmap);
      locala.setOutputSize(paramImageView.getWidth(), paramImageView.getHeight());
      locala.HkF.GpO.jQk();
      locala.aW((kotlin.g.a.b)new a(paramImageView));
      AppMethodBeat.o(329924);
    }
    
    private final void l(ImageView paramImageView)
    {
      Object localObject2 = null;
      AppMethodBeat.i(329917);
      Object localObject1 = this.ABJ;
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject2 = p.ExI;
        localObject2 = p.eCp();
        localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
        Object localObject3 = p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, paramImageView, p.a(p.a.ExM));
        AppMethodBeat.o(329917);
        return;
        localObject3 = ((FinderObject)localObject1).contact;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = c.a((FinderContact)localObject3, null, false);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((m)localObject3).amx();
          }
        }
      }
    }
    
    public final boolean d(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(329963);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      Object localObject2;
      int i;
      if (!eKU())
      {
        localObject2 = paramFrameLayout.findViewWithTag("Finder.TextStatusProvider.invalidView");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = af.mU(paramFrameLayout.getContext()).inflate(e.f.finder_text_status_invalid_view, (ViewGroup)paramFrameLayout, false);
          kotlin.g.b.s.s(localObject1, "getInflater(container.co…d_view, container, false)");
          ((View)localObject1).setTag("Finder.TextStatusProvider.invalidView");
          paramFrameLayout.removeAllViews();
          paramFrameLayout.addView((View)localObject1);
        }
        paramFrameLayout = h.baE().ban().get(at.a.adaR, "");
        if (paramFrameLayout == null)
        {
          paramFrameLayout = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(329963);
          throw paramFrameLayout;
        }
        paramFrameLayout = (String)paramFrameLayout;
        if (((CharSequence)paramFrameLayout).length() == 0)
        {
          i = 1;
          if (i == 0)
          {
            Log.i("Finder.TextStatusProvider", kotlin.g.b.s.X("[checkShowValidLayout] wording=", paramFrameLayout));
            localObject2 = (TextView)((View)localObject1).findViewById(e.e.invalid_tv);
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)paramFrameLayout);
            }
          }
          paramFrameLayout = ((View)localObject1).findViewById(e.e.invalid_container);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(0);
          }
          paramFrameLayout = ((View)localObject1).findViewById(e.e.invalid_layout);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(0);
          }
          paramFrameLayout = ((View)localObject1).findViewById(e.e.hint_invalid_layout);
          if (paramFrameLayout != null) {
            paramFrameLayout.setVisibility(8);
          }
        }
      }
      Object localObject3;
      do
      {
        AppMethodBeat.o(329963);
        return true;
        i = 0;
        break;
        localObject3 = this.ABJ;
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
        localObject2 = FinderItem.a.e((FinderObject)localObject3, ((FinderObject)localObject3).objectType);
        localObject1 = ((FinderObject)localObject3).objectDesc;
        if ((localObject1 != null) && (((FinderObjectDesc)localObject1).mediaType == 2))
        {
          i = 1;
          label341:
          if (i == 0) {
            break label432;
          }
        }
        label432:
        for (localObject1 = v.FKY;; localObject1 = v.FKZ)
        {
          localObject3 = p.ExI;
          localObject3 = p.eCl();
          localObject2 = ((FinderItem)localObject2).getMediaList().getFirst();
          kotlin.g.b.s.s(localObject2, "finderItem.mediaList.first");
          localObject1 = new com.tencent.mm.plugin.finder.loader.k((dji)localObject2, (v)localObject1);
          localObject2 = p.ExI;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, p.a(p.a.ExJ)).a(new a.b..ExternalSyntheticLambda0(paramFrameLayout)).blg();
          break;
          i = 0;
          break label341;
        }
      }
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(329970);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        l(localImageView);
        AppMethodBeat.o(329970);
        return true;
      }
    }
    
    public final boolean eKU()
    {
      AppMethodBeat.i(329949);
      Object localObject = com.tencent.mm.plugin.finder.view.a.Gwp;
      localObject = this.ABJ;
      if (localObject == null) {}
      for (long l = 0L;; l = ((FinderObject)localObject).id)
      {
        boolean bool = com.tencent.mm.plugin.finder.view.a.a.qZ(l);
        AppMethodBeat.o(329949);
        return bool;
      }
    }
    
    public final boolean eKV()
    {
      return false;
    }
    
    public final w eKW()
    {
      Object localObject3 = null;
      AppMethodBeat.i(330010);
      FinderObject localFinderObject = this.ABJ;
      if (localFinderObject == null)
      {
        AppMethodBeat.o(330010);
        return null;
      }
      Object localObject1 = localFinderObject.contact;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = an.GhR;
        if (localObject1 != null) {
          break label86;
        }
        localObject2 = null;
        label49:
        if (localObject1 != null) {
          break label94;
        }
      }
      label86:
      label94:
      for (localObject1 = localObject3;; localObject1 = ((m)localObject1).amx())
      {
        localObject1 = an.a.a((String)localObject2, (String)localObject1, localFinderObject.id, localFinderObject);
        AppMethodBeat.o(330010);
        return localObject1;
        localObject1 = c.a((FinderContact)localObject1, null, false);
        break;
        localObject2 = ((m)localObject1).getNickname();
        break label49;
      }
    }
    
    public final String etP()
    {
      AppMethodBeat.i(329954);
      Object localObject = this.ABJ;
      if (localObject == null) {}
      for (long l = 0L;; l = ((FinderObject)localObject).id)
      {
        localObject = Util.getUnsignedLongString(l);
        kotlin.g.b.s.s(localObject, "getUnsignedLongString(finderObject?.id ?: 0)");
        AppMethodBeat.o(329954);
        return localObject;
      }
    }
    
    public final boolean etQ()
    {
      return true;
    }
    
    public final CharSequence etS()
    {
      AppMethodBeat.i(329982);
      if (!eKU())
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329982);
        return localObject;
      }
      Object localObject = this.ABJ;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329982);
        return localObject;
      }
      localObject = ((FinderObject)localObject).contact;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329982);
        return localObject;
      }
      localObject = c.a((FinderContact)localObject, null, false);
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329982);
        return localObject;
      }
      localObject = ((m)localObject).getNickname();
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329982);
        return localObject;
      }
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(329982);
      return localObject;
    }
    
    public final CharSequence etT()
    {
      AppMethodBeat.i(329991);
      if (!eKU())
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329991);
        return localObject;
      }
      Object localObject = this.ABJ;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329991);
        return localObject;
      }
      localObject = ((FinderObject)localObject).objectDesc;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329991);
        return localObject;
      }
      localObject = ((FinderObjectDesc)localObject).description;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        AppMethodBeat.o(329991);
        return localObject;
      }
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(329991);
      return localObject;
    }
    
    public final boolean f(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(329976);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      paramFrameLayout.removeAllViews();
      if (!eKU())
      {
        AppMethodBeat.o(329976);
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
        l(localImageView);
        AppMethodBeat.o(329976);
        return true;
      }
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(329958);
      Log.i("Finder.TextStatusProvider", "[doJump]");
      paramBundle = new FinderObject();
      Object localObject1 = this.DHi;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextStatusJumpInfo)((Iterator)localObject1).next();
          if (kotlin.g.b.s.p(((TextStatusJumpInfo)localObject2).jumpType, "5"))
          {
            paramBundle.parseFrom(Base64.decode(((TextStatusJumpInfo)localObject2).busiBuf, 0));
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("feed_object_id", paramBundle.id);
            ((Intent)localObject1).putExtra("feed_object_nonceId", paramBundle.objectNonceId);
            ((Intent)localObject1).putExtra("key_need_related_list", false);
            localObject2 = an.GhR;
            localObject2 = FinderItem.Companion;
            localObject2 = an.a.d(FinderItem.a.e(paramBundle, 0), false);
            an.a locala = an.GhR;
            ((Intent)localObject1).putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(an.a.a((bvl)localObject2), null, null));
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("feedId", com.tencent.mm.ae.d.hF(paramBundle.id));
            paramBundle = paramBundle.contact;
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = paramBundle.username)
            {
              ((JSONObject)localObject2).put("finderusername", paramBundle);
              ((Intent)localObject1).putExtra("key_extra_info", ((JSONObject)localObject2).toString());
              ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 25, (Intent)localObject1);
              ((cn)h.az(cn.class)).enterFinderShareFeedUI(paramContext, (Intent)localObject1);
              AppMethodBeat.o(329958);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(329958);
      return false;
    }
    
    public final boolean gz(Context paramContext)
    {
      String str = null;
      AppMethodBeat.i(329999);
      kotlin.g.b.s.u(paramContext, "context");
      Intent localIntent;
      Object localObject;
      if (this.ABJ != null)
      {
        localIntent = new Intent();
        localObject = this.ABJ;
        if (localObject != null) {
          break label135;
        }
        localObject = null;
        boolean bool = kotlin.g.b.s.p(localObject, z.bAW());
        localObject = this.ABJ;
        if (localObject != null) {
          break label157;
        }
        localObject = str;
        label63:
        localIntent.putExtra("finder_username", (String)localObject);
        localObject = this.ABJ;
        if (localObject != null) {
          break label180;
        }
        localObject = "";
        label86:
        localIntent.putExtra("key_biz_username", (String)localObject);
        if (!bool) {
          break label233;
        }
        ((cn)h.az(cn.class)).enterFinderSelfProfile(paramContext, localIntent, 20, 2);
      }
      for (;;)
      {
        if (this.ABJ == null) {
          break label275;
        }
        AppMethodBeat.o(329999);
        return true;
        label135:
        localObject = ((FinderObject)localObject).contact;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = ((FinderContact)localObject).username;
        break;
        label157:
        FinderContact localFinderContact = ((FinderObject)localObject).contact;
        localObject = str;
        if (localFinderContact == null) {
          break label63;
        }
        localObject = localFinderContact.username;
        break label63;
        label180:
        localObject = ((FinderObject)localObject).contact;
        if (localObject == null)
        {
          localObject = "";
          break label86;
        }
        localObject = c.b((FinderContact)localObject);
        if (localObject == null)
        {
          localObject = "";
          break label86;
        }
        str = ((pu)localObject).ADE;
        localObject = str;
        if (str != null) {
          break label86;
        }
        localObject = "";
        break label86;
        label233:
        ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 32, localIntent);
        ((cn)h.az(cn.class)).enterFinderProfileUI(paramContext, localIntent);
      }
      label275:
      AppMethodBeat.o(329999);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(329943);
      this.DHi = paramList;
      if (paramList != null)
      {
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext())
        {
          paramList = (TextStatusJumpInfo)paramString.next();
          if (kotlin.g.b.s.p(paramList.jumpType, "5"))
          {
            paramList = Base64.decode(paramList.busiBuf, 0);
            this.ABJ = new FinderObject();
            FinderObject localFinderObject = this.ABJ;
            if (localFinderObject != null) {
              localFinderObject.parseFrom(paramList);
            }
          }
        }
      }
      AppMethodBeat.o(329943);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Bitmap, ah>
    {
      a(ImageView paramImageView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.provider.a
 * JD-Core Version:    0.7.0.1
 */