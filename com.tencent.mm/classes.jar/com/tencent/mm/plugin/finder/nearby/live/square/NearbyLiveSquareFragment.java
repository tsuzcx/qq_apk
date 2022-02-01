package com.tencent.mm.plugin.finder.nearby.live.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.bd;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.d;
import com.tencent.mm.plugin.finder.nearby.e;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarDoubleClick", "", "onDestroy", "onMenuClick", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "prepareLiveSquare", "activity", "Landroid/app/Activity;", "prepareNearbyLive", "path", "prepareNewSquare", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NearbyLiveSquareFragment
  extends AbsNearByFragment
{
  public static final a ELC;
  
  static
  {
    AppMethodBeat.i(341181);
    ELC = new a((byte)0);
    AppMethodBeat.o(341181);
  }
  
  public NearbyLiveSquareFragment()
  {
    super(e.h.nearby_tab_live, 1001);
  }
  
  private final void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(341145);
    Object localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() == 1)
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      paramString = new Bundle();
      if (paramActivity != null) {
        break label90;
      }
      i = 0;
      label46:
      paramString.putInt("key_request_scene", i);
      if (getArguments() != null) {
        break label115;
      }
      setArguments(paramString);
    }
    for (;;)
    {
      Log.i("NearbyLiveSquareFragment", s.X("prepareNearbySquare newSquareEnable:true scene:", Integer.valueOf(i)));
      AppMethodBeat.o(341145);
      return;
      i = 0;
      break;
      label90:
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null)
      {
        i = 0;
        break label46;
      }
      i = paramActivity.getIntExtra("key_request_scene", 0);
      break label46;
      label115:
      paramActivity = getArguments();
      if (paramActivity != null) {
        paramActivity.putAll(paramString);
      }
    }
    label132:
    Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    int i = 0;
    int j = 0;
    long l1 = 0L;
    Bundle localBundle = new Bundle();
    localObject1 = ((i)localObject3).Su(paramString);
    long l2 = l1;
    int m = i;
    int k = j;
    label266:
    label281:
    label296:
    label314:
    Object localObject2;
    label332:
    label350:
    Object localObject4;
    if (localObject1 != null)
    {
      l2 = l1;
      m = i;
      k = j;
      if (((p)localObject1).avK(paramString) != null)
      {
        l2 = l1;
        m = i;
        k = j;
        if (((p)localObject1).field_ctrInfo.type == 16)
        {
          ((i)localObject3).e((p)localObject1);
          paramString = ((i)localObject3).avs("NearbyLiveTab");
          if (paramString == null)
          {
            i = 0;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label734;
            }
            j = 0;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label743;
            }
            l1 = 0L;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label752;
            }
            paramString = "";
            localObject1 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject1 != null) {
              break label772;
            }
            localObject1 = "";
            localObject2 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject2 != null) {
              break label794;
            }
            localObject2 = "";
            localObject3 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject3 != null) {
              break label816;
            }
            localObject3 = "";
            localObject4 = Integer.valueOf(j);
            ((Number)localObject4).intValue();
            if (j != 1) {
              break label839;
            }
            k = 1;
            label375:
            if (k == 0) {
              break label845;
            }
            label380:
            l2 = l1;
            m = i;
            k = j;
            if (localObject4 == null) {
              break label883;
            }
            ((Number)localObject4).intValue();
            l2 = l1;
            m = i;
            k = j;
            if (l1 == 0L) {
              break label883;
            }
            localBundle.putLong("nearby_live_target_object_id_params_key", l1);
            localBundle.putInt("nearby_live_target_tab_id_params_key", i);
            localBundle.putString("nearby_live_target_nonce_id_params_key", paramString);
            localBundle.putString("nearby_live_target_user_name_params_key", (String)localObject1);
            localBundle.putString("nearby_live_target_nick_name_params_key", (String)localObject2);
            localBundle.putString("nearby_live_target_cover_url_params_key", (String)localObject3);
            com.tencent.mm.plugin.finder.nearby.live.base.b.EJG.a(l1, paramString, getCommentScene(), null);
            localObject4 = com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
            com.tencent.mm.plugin.finder.nearby.live.base.b.a(paramActivity, i, l1, paramString, (String)localObject1, (String)localObject2, (String)localObject3);
            m = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        paramString = k.aeZF;
        ((by)k.nq((Context)paramActivity).cq(by.class)).fpm();
      }
      if (i == 0)
      {
        paramString = d.EFs;
        i = d.getExitLiveTabId(getCommentScene());
        Log.i("NearbyLiveSquareFragment", "prepareNewSquare use last cache targetTabId=" + i + " commentScene=" + getCommentScene());
      }
      for (;;)
      {
        paramString = Integer.valueOf(i);
        ((Number)paramString).intValue();
        if (i != 0)
        {
          k = 1;
          label611:
          if (k == 0) {
            break label857;
          }
          label616:
          if (paramString != null)
          {
            ((Number)paramString).intValue();
            paramString = new bnn();
            paramString.ZVZ = i;
            localBundle.putByteArray("nearby_live_target_square_page_params_key", paramString.toByteArray());
          }
          if (getArguments() != null) {
            break label862;
          }
          setArguments(localBundle);
        }
        for (;;)
        {
          Log.i("NearbyLiveSquareFragment", "prepareNearbySquare newSquareEnable:false, targetTabId=" + i + " enterLiveAction:" + j + " targetObjectId:" + l1 + " activity:" + paramActivity);
          AppMethodBeat.o(341145);
          return;
          i = paramString.aabK;
          break;
          label734:
          j = paramString.aabL;
          break label266;
          label743:
          l1 = paramString.object_id;
          break label281;
          label752:
          localObject1 = paramString.object_nonce_id;
          paramString = (String)localObject1;
          if (localObject1 != null) {
            break label296;
          }
          paramString = "";
          break label296;
          label772:
          localObject1 = ((btx)localObject1).YIZ;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label314;
          }
          break label314;
          label794:
          localObject2 = ((btx)localObject2).aabM;
          if (localObject2 == null)
          {
            localObject2 = "";
            break label332;
          }
          break label332;
          label816:
          localObject4 = ((btx)localObject3).aabN;
          localObject3 = localObject4;
          if (localObject4 != null) {
            break label350;
          }
          localObject3 = "";
          break label350;
          label839:
          k = 0;
          break label375;
          label845:
          localObject4 = null;
          break label380;
          k = 0;
          break label611;
          label857:
          paramString = null;
          break label616;
          label862:
          paramString = getArguments();
          if (paramString != null) {
            paramString.putAll(localBundle);
          }
        }
      }
      label883:
      j = 1;
      l1 = l2;
      i = m;
      m = j;
      j = k;
    }
  }
  
  private final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(341169);
    Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    int i = 0;
    int j = 0;
    long l1 = 0L;
    Bundle localBundle = new Bundle();
    Object localObject1 = ((i)localObject3).Su(paramString);
    long l2 = l1;
    int m = i;
    int k = j;
    label140:
    label155:
    label170:
    label188:
    Object localObject2;
    label206:
    label224:
    Object localObject4;
    if (localObject1 != null)
    {
      l2 = l1;
      m = i;
      k = j;
      if (((p)localObject1).avK(paramString) != null)
      {
        l2 = l1;
        m = i;
        k = j;
        if (((p)localObject1).field_ctrInfo.type == 16)
        {
          ((i)localObject3).e((p)localObject1);
          paramString = ((i)localObject3).avs("NearbyLiveTab");
          if (paramString == null)
          {
            i = 0;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label628;
            }
            j = 0;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label637;
            }
            l1 = 0L;
            paramString = ((i)localObject3).avs("NearbyLiveTab");
            if (paramString != null) {
              break label646;
            }
            paramString = "";
            localObject1 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject1 != null) {
              break label666;
            }
            localObject1 = "";
            localObject2 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject2 != null) {
              break label688;
            }
            localObject2 = "";
            localObject3 = ((i)localObject3).avs("NearbyLiveTab");
            if (localObject3 != null) {
              break label710;
            }
            localObject3 = "";
            localObject4 = Integer.valueOf(j);
            ((Number)localObject4).intValue();
            if (j != 1) {
              break label733;
            }
            k = 1;
            label249:
            if (k == 0) {
              break label739;
            }
            label254:
            l2 = l1;
            m = i;
            k = j;
            if (localObject4 == null) {
              break label777;
            }
            ((Number)localObject4).intValue();
            l2 = l1;
            m = i;
            k = j;
            if (l1 == 0L) {
              break label777;
            }
            localBundle.putLong("nearby_live_target_object_id_params_key", l1);
            localBundle.putInt("nearby_live_target_tab_id_params_key", i);
            localBundle.putString("nearby_live_target_nonce_id_params_key", paramString);
            localBundle.putString("nearby_live_target_user_name_params_key", (String)localObject1);
            localBundle.putString("nearby_live_target_nick_name_params_key", (String)localObject2);
            localBundle.putString("nearby_live_target_cover_url_params_key", (String)localObject3);
            com.tencent.mm.plugin.finder.nearby.live.base.b.EJG.a(l1, paramString, getCommentScene(), null);
            localObject4 = com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
            com.tencent.mm.plugin.finder.nearby.live.base.b.a(paramActivity, i, l1, paramString, (String)localObject1, (String)localObject2, (String)localObject3);
            m = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        paramString = k.aeZF;
        ((by)k.nq((Context)paramActivity).cq(by.class)).fpm();
      }
      if (i == 0)
      {
        paramString = com.tencent.d.a.a.a.a.a.ahiX;
        if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() == 0)
        {
          paramString = d.EFs;
          i = d.getExitLiveTabId(getCommentScene());
          Log.i("NearbyLiveSquareFragment", "prepareNearbyLive use last cache targetTabId=" + i + " commentScene=" + getCommentScene());
        }
      }
      for (;;)
      {
        paramString = Integer.valueOf(i);
        ((Number)paramString).intValue();
        if (i != 0)
        {
          k = 1;
          label504:
          if (k == 0) {
            break label751;
          }
          label509:
          if (paramString != null)
          {
            ((Number)paramString).intValue();
            paramString = new bnn();
            paramString.ZVZ = i;
            localBundle.putByteArray("nearby_live_target_square_page_params_key", paramString.toByteArray());
          }
          if (getArguments() != null) {
            break label756;
          }
          setArguments(localBundle);
        }
        for (;;)
        {
          Log.i("NearbyLiveSquareFragment", "prepareNearbyLive targetTabId=" + i + " enterLiveAction:" + j + " targetObjectId:" + l1 + " activity:" + paramActivity);
          AppMethodBeat.o(341169);
          return;
          i = paramString.aabK;
          break;
          label628:
          j = paramString.aabL;
          break label140;
          label637:
          l1 = paramString.object_id;
          break label155;
          label646:
          localObject1 = paramString.object_nonce_id;
          paramString = (String)localObject1;
          if (localObject1 != null) {
            break label170;
          }
          paramString = "";
          break label170;
          label666:
          localObject1 = ((btx)localObject1).YIZ;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label188;
          }
          break label188;
          label688:
          localObject2 = ((btx)localObject2).aabM;
          if (localObject2 == null)
          {
            localObject2 = "";
            break label206;
          }
          break label206;
          label710:
          localObject4 = ((btx)localObject3).aabN;
          localObject3 = localObject4;
          if (localObject4 != null) {
            break label224;
          }
          localObject3 = "";
          break label224;
          label733:
          k = 0;
          break label249;
          label739:
          localObject4 = null;
          break label254;
          k = 0;
          break label504;
          label751:
          paramString = null;
          break label509;
          label756:
          paramString = getArguments();
          if (paramString != null) {
            paramString.putAll(localBundle);
          }
        }
      }
      label777:
      j = 1;
      l1 = l2;
      i = m;
      m = j;
      j = k;
    }
  }
  
  public final void aG(Activity paramActivity)
  {
    AppMethodBeat.i(341209);
    s.u(paramActivity, "activity");
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      h(paramActivity, "FinderLiveEntrance");
      AppMethodBeat.o(341209);
      return;
    }
    i(paramActivity, "NearbyEntrance");
    AppMethodBeat.o(341209);
  }
  
  public final void eEp()
  {
    AppMethodBeat.i(341225);
    super.eEp();
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb2 = ((b)component(b.class)).ELF;
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("livePostHelper");
      localb1 = null;
    }
    localb1.prepare();
    j.Dob.a(q.bd.DAC);
    AppMethodBeat.o(341225);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(341241);
    super.eEr();
    NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).eFC();
    if (localNearbyLiveSquareTabFragment != null) {
      localNearbyLiveSquareTabFragment.eEr();
    }
    AppMethodBeat.o(341241);
  }
  
  public String eEt()
  {
    return "1001";
  }
  
  public final String eEw()
  {
    return "";
  }
  
  public int edC()
  {
    return 3;
  }
  
  public int getCommentScene()
  {
    return 94;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(341193);
    Set localSet = ar.setOf(new Class[] { as.class, com.tencent.mm.plugin.finder.nearby.live.square.page.a.class, com.tencent.mm.plugin.finder.nearby.live.square.tab.b.class, b.class });
    AppMethodBeat.o(341193);
    return localSet;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(341298);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.a.EQq;
    com.tencent.mm.plugin.finder.nearby.report.a.reset();
    localObject = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    com.tencent.mm.plugin.finder.live.fluent.g.release();
    AppMethodBeat.o(341298);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(341275);
    super.onPause();
    Log.i("NearbyLiveSquareFragment", "onPause()");
    Object localObject = getActivity();
    if (localObject != null)
    {
      k localk = k.aeZF;
      if ((((e)k.nq((Context)localObject).q(e.class)).eEg() instanceof NearbyLiveSquareFragment))
      {
        localObject = com.tencent.mm.plugin.finder.nearby.report.g.ERj;
        com.tencent.mm.plugin.finder.nearby.report.g.e((AbsNearByFragment)((b)component(b.class)).eFC());
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onPause();
    AppMethodBeat.o(341275);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(341284);
    super.onResume();
    Log.i("NearbyLiveSquareFragment", "onResume()");
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.g.ERj;
    com.tencent.mm.plugin.finder.nearby.report.g.eGN();
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onResume();
    AppMethodBeat.o(341284);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(341251);
    super.onUserVisibleFocused();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).eFC();
      if (localNearbyLiveSquareTabFragment != null) {
        localNearbyLiveSquareTabFragment.onUserVisibleFocused();
      }
    }
    AppMethodBeat.o(341251);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(341258);
    super.onUserVisibleUnFocused();
    NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).eFC();
    if (localNearbyLiveSquareTabFragment != null) {
      localNearbyLiveSquareTabFragment.onUserVisibleUnFocused();
    }
    AppMethodBeat.o(341258);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
 * JD-Core Version:    0.7.0.1
 */