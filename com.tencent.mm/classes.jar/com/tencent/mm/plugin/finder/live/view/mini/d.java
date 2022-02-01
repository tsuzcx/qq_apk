package com.tencent.mm.plugin.finder.live.view.mini;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.view.ratio.RatioLayout;
import com.tencent.mm.view.ratio.RatioLayout.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/mini/FinderMiniWindowFloatLayoutAdapter;", "Lcom/tencent/mm/view/ratio/RatioLayoutAdapter;", "Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowData;", "()V", "TAG", "", "audienceLinkMicUserList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "defaultLayoutInfoList", "", "Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;", "isMicingByLocal", "", "layoutInfoList1", "layoutInfoList2", "layoutInfoList3", "layoutInfoList4", "linkMicUser", "micData", "Lorg/json/JSONObject;", "muteVideoBitmap", "Landroid/graphics/Bitmap;", "roomPkMicUserList", "Lorg/json/JSONArray;", "sourceType", "", "checkDiff", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "createAnchorAudioItemView", "Landroid/view/View;", "bitmap", "createEmptyItemView", "createItemView", "index", "isAudio", "username", "bgUrl", "nickname", "avatarUrl", "getDefaultLayoutInfo", "totalCount", "getItemCount", "getItemData", "pos", "getItemView", "data", "getLayoutInfo", "parseAnchorLayoutInfo", "parseLinkMicUserLayoutInfo", "info", "refreshData", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.view.ratio.a<a>
{
  public static final d.a DVM;
  private static int DVX;
  private static JSONObject lastMicData;
  private ArrayList<h> DVN;
  private JSONObject DVO;
  private JSONArray DVP;
  private boolean DVQ;
  private Bitmap DVR;
  private final ArrayList<RatioLayout.a> DVS;
  private final ArrayList<RatioLayout.a> DVT;
  private final ArrayList<RatioLayout.a> DVU;
  private final ArrayList<RatioLayout.a> DVV;
  private final List<ArrayList<RatioLayout.a>> DVW;
  private h DVy;
  private final String TAG;
  private int sourceType;
  
  static
  {
    AppMethodBeat.i(358405);
    DVM = new d.a((byte)0);
    AppMethodBeat.o(358405);
  }
  
  public d()
  {
    AppMethodBeat.i(358282);
    this.TAG = "Finder.FinderMiniWindowFloatLayoutAdapter";
    this.DVN = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RatioLayout.a(0.0F, 0.0F, 1.0F, 1.0F));
    ah localah = ah.aiuX;
    this.DVS = localArrayList;
    localArrayList = new ArrayList();
    localArrayList.add(new RatioLayout.a(0.0F, 0.0F, 0.5F, 1.0F));
    localArrayList.add(new RatioLayout.a(0.5F, 0.0F, 0.5F, 1.0F));
    localah = ah.aiuX;
    this.DVT = localArrayList;
    localArrayList = new ArrayList();
    localArrayList.add(new RatioLayout.a(0.0F, 0.0F, 0.5F, 1.0F));
    localArrayList.add(new RatioLayout.a(0.5F, 0.0F, 0.5F, 0.5F));
    localArrayList.add(new RatioLayout.a(0.5F, 0.5F, 0.5F, 0.5F));
    localah = ah.aiuX;
    this.DVU = localArrayList;
    localArrayList = new ArrayList();
    localArrayList.add(new RatioLayout.a(0.0F, 0.0F, 0.5F, 0.5F));
    localArrayList.add(new RatioLayout.a(0.5F, 0.0F, 0.5F, 0.5F));
    localArrayList.add(new RatioLayout.a(0.0F, 0.5F, 0.5F, 0.5F));
    localArrayList.add(new RatioLayout.a(0.5F, 0.5F, 0.5F, 0.5F));
    localah = ah.aiuX;
    this.DVV = localArrayList;
    this.DVW = p.listOf(new ArrayList[] { this.DVS, this.DVT, this.DVU, this.DVV });
    AppMethodBeat.o(358282);
  }
  
  private final View ewg()
  {
    AppMethodBeat.i(358289);
    View localView = LayoutInflater.from(jNh().getContext()).inflate(p.f.Cep, (ViewGroup)jNh(), false);
    localView.findViewById(p.e.BBN).setVisibility(8);
    localView.findViewById(p.e.BBH).setVisibility(8);
    localView.findViewById(p.e.video_layout).setVisibility(8);
    s.s(localView, "itemView");
    AppMethodBeat.o(358289);
    return localView;
  }
  
  private final RatioLayout.a hO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358299);
    Object localObject = ((ArrayList)this.DVW.get(paramInt2 - 1)).get(paramInt1);
    s.s(localObject, "defaultLayoutInfoList[totalCount - 1][index]");
    localObject = (RatioLayout.a)localObject;
    AppMethodBeat.o(358299);
    return localObject;
  }
  
  public final RatioLayout.a PG(int paramInt)
  {
    Object localObject1 = null;
    float f4 = 1.0F;
    AppMethodBeat.i(358434);
    switch (this.sourceType)
    {
    default: 
      localObject1 = new RatioLayout.a(0.0F, 0.0F, 1.0F, 1.0F);
      AppMethodBeat.o(358434);
      return localObject1;
    case 1: 
      localObject1 = hO(paramInt, 2);
      AppMethodBeat.o(358434);
      return localObject1;
    case 2: 
      localObject1 = hO(paramInt, getItemCount());
      AppMethodBeat.o(358434);
      return localObject1;
    }
    Object localObject2 = this.DVO;
    if (localObject2 == null) {}
    while (localObject1 == null)
    {
      localObject1 = new RatioLayout.a(0.0F, 0.0F, 0.0F, 0.0F);
      AppMethodBeat.o(358434);
      return localObject1;
      float f1;
      label177:
      float f2;
      label209:
      float f3;
      if (paramInt == 0)
      {
        localObject1 = ((JSONObject)localObject2).optString("x");
        s.s(localObject1, "micData.optString(\"x\")");
        localObject1 = n.bJE((String)localObject1);
        if (localObject1 == null)
        {
          f1 = 0.0F;
          localObject1 = ((JSONObject)localObject2).optString("y");
          s.s(localObject1, "micData.optString(\"y\")");
          localObject1 = n.bJE((String)localObject1);
          if (localObject1 != null) {
            break label299;
          }
          f2 = 0.0F;
          localObject1 = ((JSONObject)localObject2).optString("w");
          s.s(localObject1, "micData.optString(\"w\")");
          localObject1 = n.bJE((String)localObject1);
          if (localObject1 != null) {
            break label308;
          }
          f3 = 1.0F;
          label242:
          localObject1 = ((JSONObject)localObject2).optString("h");
          s.s(localObject1, "micData.optString(\"h\")");
          localObject1 = n.bJE((String)localObject1);
          if (localObject1 != null) {
            break label318;
          }
        }
        for (;;)
        {
          localObject1 = new RatioLayout.a(f1, f2, f3, f4);
          break;
          f1 = ((Float)localObject1).floatValue();
          break label177;
          label299:
          f2 = ((Float)localObject1).floatValue();
          break label209;
          label308:
          f3 = ((Float)localObject1).floatValue();
          break label242;
          label318:
          f4 = ((Float)localObject1).floatValue();
        }
      }
      localObject1 = ((JSONObject)localObject2).optJSONArray("list");
      int i;
      if (localObject1 == null)
      {
        i = 0;
        label345:
        if (i <= 0) {
          break label619;
        }
        if (localObject1 != null) {
          break label416;
        }
        localObject1 = null;
        label358:
        if (localObject1 != null) {
          break label429;
        }
        f1 = 0.0F;
        label365:
        if (localObject1 != null) {
          break label475;
        }
        f2 = 0.0F;
        label372:
        if (localObject1 != null) {
          break label521;
        }
        f3 = 0.0F;
        label380:
        if (localObject1 != null) {
          break label570;
        }
        f4 = 0.0F;
      }
      for (;;)
      {
        localObject1 = new RatioLayout.a(f1, f2, f3, f4);
        break;
        i = ((JSONArray)localObject1).length();
        break label345;
        label416:
        localObject1 = ((JSONArray)localObject1).optJSONObject(paramInt - 1);
        break label358;
        label429:
        localObject2 = ((JSONObject)localObject1).optString("x");
        if (localObject2 == null)
        {
          f1 = 0.0F;
          break label365;
        }
        localObject2 = n.bJE((String)localObject2);
        if (localObject2 == null)
        {
          f1 = 0.0F;
          break label365;
        }
        f1 = ((Float)localObject2).floatValue();
        break label365;
        label475:
        localObject2 = ((JSONObject)localObject1).optString("y");
        if (localObject2 == null)
        {
          f2 = 0.0F;
          break label372;
        }
        localObject2 = n.bJE((String)localObject2);
        if (localObject2 == null)
        {
          f2 = 0.0F;
          break label372;
        }
        f2 = ((Float)localObject2).floatValue();
        break label372;
        label521:
        localObject2 = ((JSONObject)localObject1).optString("w");
        if (localObject2 == null)
        {
          f3 = 0.0F;
          break label380;
        }
        localObject2 = n.bJE((String)localObject2);
        if (localObject2 == null)
        {
          f3 = 0.0F;
          break label380;
        }
        f3 = ((Float)localObject2).floatValue();
        break label380;
        label570:
        localObject1 = ((JSONObject)localObject1).optString("h");
        if (localObject1 == null)
        {
          f4 = 0.0F;
        }
        else
        {
          localObject1 = n.bJE((String)localObject1);
          if (localObject1 == null) {
            f4 = 0.0F;
          } else {
            f4 = ((Float)localObject1).floatValue();
          }
        }
      }
      label619:
      localObject1 = new RatioLayout.a(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(358434);
    return localObject1;
  }
  
  public final void a(boolean paramBoolean, final com.tencent.mm.plugin.finder.live.model.context.a parama, final int paramInt, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(358412);
    s.u(parama, "buContext");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramBoolean, this, paramInt, paramJSONObject, parama));
    AppMethodBeat.o(358412);
  }
  
  public final int getItemCount()
  {
    int i = 0;
    AppMethodBeat.i(358421);
    if (this.DVQ)
    {
      AppMethodBeat.o(358421);
      return 0;
    }
    switch (this.sourceType)
    {
    default: 
      AppMethodBeat.o(358421);
      return 0;
    case 1: 
      AppMethodBeat.o(358421);
      return 2;
    case 2: 
      i = this.DVN.size();
      AppMethodBeat.o(358421);
      return i + 1;
    }
    Object localObject = this.DVO;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label121;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(358421);
      return i + 1;
      localObject = ((JSONObject)localObject).optJSONArray("list");
      break;
      label121:
      i = ((JSONArray)localObject).length();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(boolean paramBoolean, d paramd, int paramInt, JSONObject paramJSONObject, com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.mini.d
 * JD-Core Version:    0.7.0.1
 */