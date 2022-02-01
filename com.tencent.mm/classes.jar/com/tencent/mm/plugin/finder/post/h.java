package com.tencent.mm.plugin.finder.post;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostTopicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/finder/post/PostTopicUIC$RvAdapter;", "addTopicToEdit", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "topic", "inputTopic", "", "getAddTopicToEdit", "()Lkotlin/jvm/functions/Function2;", "setAddTopicToEdit", "(Lkotlin/jvm/functions/Function2;)V", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "footerTopicLayout", "Landroid/widget/LinearLayout;", "hasTopicData", "", "onTopicShow", "Lkotlin/Function0;", "getOnTopicShow", "()Lkotlin/jvm/functions/Function0;", "setOnTopicShow", "(Lkotlin/jvm/functions/Function0;)V", "topicCharStart", "", "topicCount", "topicStr", "filterTopic", "editable", "Landroid/text/Editable;", "start", "handleTextChanged", "s", "selectionStart", "hideTopic", "initTopicList", "list", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "report21875", "eventCode", "num", "requestPostPreData", "showTopic", "Companion", "RvAdapter", "ViewHolder", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  public static final a ETZ;
  LinearLayout EUa;
  boolean EUb;
  private int EUc;
  m<? super String, ? super String, ah> EUd;
  kotlin.g.a.a<ah> EUe;
  b EUf;
  int EUg;
  String EUh;
  List<? extends bxv> dataList;
  
  static
  {
    AppMethodBeat.i(349482);
    ETZ = new a((byte)0);
    AppMethodBeat.o(349482);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349410);
    this.EUg = -1;
    this.EUh = "";
    AppMethodBeat.o(349410);
  }
  
  private static final ah a(h paramh, b.a parama)
  {
    AppMethodBeat.i(349441);
    s.u(paramh, "this$0");
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      if (!((bsv)parama.ott).aaax.isEmpty())
      {
        paramh.EUb = true;
        paramh.EUc = ((bsv)parama.ott).aaax.size();
        localObject = ((bsv)parama.ott).aaax;
        s.s(localObject, "it.resp.usual_topics");
        List localList = (List)localObject;
        paramh.dataList = localList;
        paramh.EUa = ((LinearLayout)paramh.getActivity().findViewById(l.e.footer_topic_layout));
        localObject = paramh.EUa;
        if (localObject != null) {
          ((LinearLayout)localObject).setOnClickListener(h..ExternalSyntheticLambda0.INSTANCE);
        }
        localObject = paramh.EUa;
        if (localObject != null) {
          break label246;
        }
        localObject = null;
        if (localObject != null)
        {
          paramh.getActivity();
          ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
          ((RecyclerView)localObject).a((RecyclerView.h)new d(paramh));
          paramh.EUf = new b(localList, (m)new e(paramh));
          ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramh.EUf);
        }
      }
      Log.i("Finder.PostTopicUIC", s.X("[requestPostPreData] usual_topics.size=", Integer.valueOf(((bsv)parama.ott).aaax.size())));
    }
    for (;;)
    {
      paramh = ah.aiuX;
      AppMethodBeat.o(349441);
      return paramh;
      label246:
      localObject = (RecyclerView)((LinearLayout)localObject).findViewById(l.e.footer_topic_list);
      break;
      Log.i("Finder.PostTopicUIC", "[requestPostPreData] errType=" + parama.errType + " errCode=" + parama.errCode + " errMsg=" + parama.errMsg);
    }
  }
  
  private static final void gB(View paramView)
  {
    AppMethodBeat.i(349450);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostTopicUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostTopicUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349450);
  }
  
  private final void q(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(349418);
    JSONObject localJSONObject = new JSONObject();
    if (paramInt1 == 0) {}
    try
    {
      localJSONObject.put("topic_num", this.EUc);
      for (;;)
      {
        paramString = as.GSQ;
        paramString = as.a.hu((Context)getContext());
        if (paramString != null) {
          break;
        }
        paramString = null;
        bb localbb = bb.FuK;
        bb.a(paramString, "post_comm_topic_page", paramInt1, localJSONObject);
        AppMethodBeat.o(349418);
        return;
        localJSONObject.put("topic", paramString);
        localJSONObject.put("num", paramInt2);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        continue;
        paramString = paramString.fou();
      }
    }
  }
  
  final void eHA()
  {
    AppMethodBeat.i(349515);
    LinearLayout localLinearLayout = this.EUa;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    this.EUg = -1;
    this.EUh = "";
    AppMethodBeat.o(349515);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349507);
    super.onCreate(paramBundle);
    new am().bFJ().a((com.tencent.mm.vending.e.b)getActivity()).g(new h..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(349507);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostTopicUIC$Companion;", "", "()V", "EID_POST_COMM_TOPIC_PAGE", "", "TAG", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostTopicUIC$RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/post/PostTopicUIC$ViewHolder;", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "topic", "", "pos", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.a<h.c>
  {
    private final m<String, Integer, ah> EUi;
    private List<? extends bxv> dataList;
    
    public b(List<? extends bxv> paramList, m<? super String, ? super Integer, ah> paramm)
    {
      AppMethodBeat.i(349500);
      this.dataList = paramList;
      this.EUi = paramm;
      AppMethodBeat.o(349500);
    }
    
    private static final void a(b paramb, bxv parambxv, int paramInt, View paramView)
    {
      AppMethodBeat.i(349509);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(parambxv);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostTopicUIC$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      s.u(parambxv, "$data");
      paramb.EUi.invoke(parambxv.topic, Integer.valueOf(paramInt + 1));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostTopicUIC$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349509);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(349531);
      int i = this.dataList.size();
      AppMethodBeat.o(349531);
      return i;
    }
    
    public final void setData(List<? extends bxv> paramList)
    {
      AppMethodBeat.i(349522);
      s.u(paramList, "dataList");
      this.dataList = paramList;
      this.bZE.notifyChanged();
      AppMethodBeat.o(349522);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostTopicUIC$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "topicTv", "Landroid/widget/TextView;", "getTopicTv", "()Landroid/widget/TextView;", "setTopicTv", "(Landroid/widget/TextView;)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.v
  {
    TextView EUj;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(349490);
      this.EUj = ((TextView)paramView.findViewById(l.e.Fig));
      AppMethodBeat.o(349490);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/post/PostTopicUIC$initTopicList$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.h
  {
    d(h paramh) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(349499);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int j = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_5_A);
      paramRect.left = j;
      int k = RecyclerView.bA(paramView);
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null)
      {
        paramView = null;
        if (paramView != null) {
          break label117;
        }
      }
      label117:
      for (int i = h.b(this.EUk);; i = paramView.intValue())
      {
        if (k != i - 1) {
          break label126;
        }
        paramRect.right = (j * 6);
        AppMethodBeat.o(349499);
        return;
        paramView = Integer.valueOf(paramView.getItemCount());
        break;
      }
      label126:
      paramRect.right = j;
      AppMethodBeat.o(349499);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "topic", "", "num", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<String, Integer, ah>
  {
    e(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.h
 * JD-Core Version:    0.7.0.1
 */