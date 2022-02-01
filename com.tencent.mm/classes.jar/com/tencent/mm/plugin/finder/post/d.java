package com.tencent.mm.plugin.finder.post;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.storage.logic.h;
import com.tencent.mm.plugin.finder.upload.postui.i;
import com.tencent.mm.plugin.finder.view.FinderJumperView;
import com.tencent.mm.plugin.finder.view.FinderTencentVideoChooseView;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostJumpInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "isFromCampaign", "", "()Z", "setFromCampaign", "(Z)V", "jumperWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "getJumperWidget", "()Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "setJumperWidget", "(Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;)V", "onSelectItem", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSelected", "", "getOnSelectItem", "()Lkotlin/jvm/functions/Function1;", "setOnSelectItem", "(Lkotlin/jvm/functions/Function1;)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "createDefaultWidget", "jumpInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "createProductWidget", "createTencentVideoWidget", "jumpInfo", "createWidget", "getPostData", "refreshJumpInfoList", "restore", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  private final kotlin.j ETb;
  boolean ETp;
  com.tencent.mm.plugin.finder.upload.postui.j ETq;
  kotlin.g.a.b<? super Boolean, ah> ETr;
  private final String TAG;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349438);
    this.TAG = "Finder.PostJumpInfoUIC";
    this.ETb = kotlin.k.cm((a)new a(paramAppCompatActivity));
    AppMethodBeat.o(349438);
  }
  
  private final com.tencent.mm.plugin.finder.widget.post.c eHl()
  {
    AppMethodBeat.i(349444);
    com.tencent.mm.plugin.finder.widget.post.c localc = (com.tencent.mm.plugin.finder.widget.post.c)this.ETb.getValue();
    AppMethodBeat.o(349444);
    return localc;
  }
  
  private final void hk(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(349483);
    Object localObject1 = getActivity();
    Object localObject2 = getActivity().findViewById(l.e.choose_product_view);
    s.s(localObject2, "activity.findViewById(R.id.choose_product_view)");
    localObject1 = new com.tencent.mm.plugin.finder.upload.postui.b((AppCompatActivity)localObject1, (FinderJumperView)localObject2);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).ETr = this.ETr;
    localObject2 = ah.aiuX;
    this.ETq = ((com.tencent.mm.plugin.finder.upload.postui.j)localObject1);
    localObject1 = this.ETq;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.upload.postui.j)localObject1).hG(paramList);
    }
    Log.i(this.TAG, s.X("createProductWidget ", this.ETq));
    AppMethodBeat.o(349483);
  }
  
  private final void hl(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(349492);
    Object localObject = getActivity();
    View localView = getActivity().findViewById(l.e.choose_product_view);
    s.s(localView, "activity.findViewById(R.id.choose_product_view)");
    this.ETq = ((com.tencent.mm.plugin.finder.upload.postui.j)new com.tencent.mm.plugin.finder.upload.postui.c((AppCompatActivity)localObject, (FinderJumperView)localView));
    localObject = this.ETq;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.upload.postui.j)localObject).hG(paramList);
    }
    if (paramList != null)
    {
      paramList = this.ETr;
      if (paramList != null) {
        paramList.invoke(Boolean.TRUE);
      }
    }
    Log.i(this.TAG, s.X("createProductWidget ", this.ETq));
    AppMethodBeat.o(349492);
  }
  
  private final void n(List<? extends FinderJumpInfo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(349465);
    if (paramList == null) {}
    for (Object localObject2 = null;; localObject2 = (FinderJumpInfo)p.oL(paramList))
    {
      this.ETp = paramBoolean;
      if ((paramList != null) && (localObject2 != null)) {
        break;
      }
      hk(null);
      AppMethodBeat.o(349465);
      return;
    }
    int j = ((FinderJumpInfo)localObject2).jumpinfo_type;
    if (j == 1)
    {
      if (((FinderJumpInfo)localObject2).business_type == 1)
      {
        hk(paramList);
        AppMethodBeat.o(349465);
        return;
      }
      hl(paramList);
      AppMethodBeat.o(349465);
      return;
    }
    int i;
    label107:
    Object localObject1;
    if (j == 2)
    {
      i = 1;
      if (i == 0) {
        break label525;
      }
      i = 1;
      if (i == 0) {
        break label747;
      }
      if (((FinderJumpInfo)localObject2).business_type != 13) {
        break label732;
      }
      paramList = eHl().GZV;
      if (paramList == null) {
        break label753;
      }
      localObject1 = paramList.Rfi;
      if (localObject1 == null) {
        break label546;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label541;
      }
      i = 1;
      label159:
      if (i != 0) {
        break label546;
      }
      i = 1;
      label165:
      if (i == 0) {
        break label551;
      }
      paramList = s.X("cid=", paramList.Rfi);
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        Object localObject5 = (c)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(c.class);
        localObject1 = ((FinderJumpInfo)localObject2).wording;
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localObject1 = ((FinderJumpInfo)localObject2).html5_info;
        if (localObject1 == null)
        {
          localObject1 = "";
          label248:
          localObject2 = ((FinderJumpInfo)localObject2).html5_info;
          if (localObject2 != null) {
            break label635;
          }
        }
        Object localObject4;
        label525:
        label541:
        label546:
        label551:
        label577:
        label606:
        label635:
        for (i = 2;; i = ((Html5Info)localObject2).style)
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = "";
          }
          s.u(localObject3, "title");
          s.u(localObject1, "link");
          s.u(localObject2, "optionalInfo");
          ((c)localObject5).eHk();
          paramList = ((c)localObject5).getActivity();
          localObject4 = ((c)localObject5).getActivity().findViewById(l.e.choose_tencent_video_view);
          s.s(localObject4, "activity.findViewById(R.…hoose_tencent_video_view)");
          ((c)localObject5).ETh = new i(paramList, (FinderTencentVideoChooseView)localObject4);
          ((c)localObject5).eHg().ETq = ((com.tencent.mm.plugin.finder.upload.postui.j)((c)localObject5).ETh);
          paramList = ((c)localObject5).ETh;
          if (paramList == null) {
            break label726;
          }
          localObject4 = (a)new c.b((c)localObject5);
          s.u(localObject3, "title");
          s.u(localObject1, "link");
          s.u(localObject2, "optionalInfo");
          localObject2 = new FinderJumpInfo();
          ((FinderJumpInfo)localObject2).jumpinfo_type = 2;
          ((FinderJumpInfo)localObject2).business_type = 13;
          ((FinderJumpInfo)localObject2).source = 1;
          ((FinderJumpInfo)localObject2).wording = ((String)localObject3);
          localObject3 = h.FNM;
          localObject3 = ((Iterable)h.fat()).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (bre)((Iterator)localObject3).next();
            if (((bre)localObject5).ZZh == 2) {
              ((FinderJumpInfo)localObject2).icon_url = ((bre)localObject5).ZZi;
            }
          }
          if (j == 3)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          if (j == 4)
          {
            i = 1;
            break label107;
          }
          i = 0;
          break label107;
          i = 0;
          break label159;
          i = 0;
          break label165;
          localObject1 = paramList.ZZV;
          if (localObject1 != null) {
            if (((CharSequence)localObject1).length() == 0)
            {
              i = 1;
              if (i != 0) {
                break label606;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label753;
            }
            paramList = s.X("lid=", paramList.ZZV);
            break;
            i = 0;
            break label577;
          }
          localObject4 = ((Html5Info)localObject1).url;
          localObject1 = localObject4;
          if (localObject4 != null) {
            break label248;
          }
          localObject1 = "";
          break label248;
        }
        localObject3 = new Html5Info();
        ((Html5Info)localObject3).url = ((String)localObject1);
        ((Html5Info)localObject3).style = i;
        localObject1 = ah.aiuX;
        ((FinderJumpInfo)localObject2).html5_info = ((Html5Info)localObject3);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = ah.aiuX;
        paramList.hG((List)localObject1);
        if (ah.aiuX == null) {
          paramList.hG(null);
        }
        paramList.Gft = ((a)localObject4);
      }
      label726:
      AppMethodBeat.o(349465);
      return;
      label732:
      if (((FinderJumpInfo)localObject2).business_type != 6) {
        hl(paramList);
      }
      label747:
      AppMethodBeat.o(349465);
      return;
      label753:
      paramList = null;
    }
  }
  
  public final void o(List<? extends FinderJumpInfo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(349508);
    if (paramList != null)
    {
      eHl().hVf = ((FinderJumpInfo)p.oL(paramList));
      n(paramList, paramBoolean);
    }
    AppMethodBeat.o(349508);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(349502);
    Object localObject2 = eHl().hVf;
    if (localObject2 == null) {}
    for (Object localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        a(this, null);
      }
      AppMethodBeat.o(349502);
      return;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject2);
      localObject2 = ah.aiuX;
      a(this, (List)localObject1);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<com.tencent.mm.plugin.finder.widget.post.c>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.d
 * JD-Core Version:    0.7.0.1
 */