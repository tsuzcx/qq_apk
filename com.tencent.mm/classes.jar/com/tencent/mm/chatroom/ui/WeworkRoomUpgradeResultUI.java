package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private String gBW;
  private ArrayList<String> gBX;
  private ArrayList<String> gBY;
  private ImageView gBZ;
  private Button gCa;
  private a gCb;
  private int gwE;
  private Button gwO;
  private LinearLayout gwU;
  private RecyclerView gwW;
  private String gwx;
  private LinearLayoutManager gxa;
  private ManagerRoomByWeworkUI.b gxc;
  private TextView titleTv;
  
  public static void cr(Context paramContext)
  {
    AppMethodBeat.i(194206);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(194206);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(194206);
  }
  
  public int getLayoutId()
  {
    return 2131497094;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(182222);
    super.initView();
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131099650));
    setBackGroundColorResource(2131099650);
    setMMTitle("");
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.gBZ = ((ImageView)findViewById(2131302468));
    this.titleTv = ((TextView)findViewById(2131299222));
    this.gwU = ((LinearLayout)findViewById(2131302189));
    this.gwW = ((RecyclerView)findViewById(2131297056));
    this.gwO = ((Button)findViewById(2131301538));
    this.gCa = ((Button)findViewById(2131302149));
    if (this.gwE == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gBZ.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 48);
      this.gBZ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(2131299197).setVisibility(8);
      this.gwW.setVisibility(0);
      this.gxa = new LinearLayoutManager();
      this.gxa.setOrientation(1);
      this.gwW.setLayoutManager(this.gxa);
      this.gxc = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.gwW.a(this.gxc);
      this.gCb = new a(getContext(), this.gBX, this.gBY);
      this.gwW.setAdapter(this.gCb);
      this.gCb.atj.notifyChanged();
      this.gwO.setVisibility(8);
      this.gCa.setVisibility(0);
      this.gCa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.cr(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(2131299197)).setText(this.gBW);
    this.gwW.setVisibility(8);
    this.gwO.setVisibility(0);
    this.gCa.setVisibility(8);
    this.gwO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194200);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        c.f(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194200);
      }
    });
    AppMethodBeat.o(182222);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(182220);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gwE = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.gwE) });
    if ((this.gwE != 3) && (Util.isNullOrNil(this.gwx)))
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.gBW = getIntent().getStringExtra("popup_wording");
      this.gBX = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.gBY = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
      i = 1;
    }
    initView();
    AppMethodBeat.o(182220);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182221);
    super.onDestroy();
    AppMethodBeat.o(182221);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends RecyclerView.a
  {
    private Context context;
    private ArrayList<String> gBX;
    private ArrayList<String> gBY;
    private List<as> gxh;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(194201);
      this.context = paramContext;
      this.gBX = paramArrayList1;
      this.gBY = paramArrayList2;
      this.gxh = new ArrayList();
      paramContext = this.gBX.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.af(l.class)).aSN().Kn(paramArrayList1);
        this.gxh.add(paramArrayList1);
      }
      paramContext = this.gBY.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.af(l.class)).aSN().Kn(paramArrayList1);
        this.gxh.add(paramArrayList1);
      }
      AppMethodBeat.o(194201);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(194202);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131497093, paramViewGroup, false));
      AppMethodBeat.o(194202);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(194203);
      if ((this.gxh != null) && (paramInt >= 0) && (paramInt < this.gxh.size()))
      {
        paramv = (WeworkRoomUpgradeResultUI.b)paramv;
        as localas = (as)this.gxh.get(paramInt);
        Log.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localas.field_username });
        paramv.gvQ.setVisibility(0);
        ManagerRoomByWeworkUI.a(localas.field_username, paramv.gwQ);
        if (this.gBX.contains(localas.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.gxs, paramv.gxt, true);
          paramv.gCd.setVisibility(8);
          AppMethodBeat.o(194203);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.gxs, paramv.gxt, false);
        paramv.gCd.setVisibility(0);
        paramv.gCd.setText(2131766977);
      }
      AppMethodBeat.o(194203);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(194204);
      int i = this.gxh.size();
      AppMethodBeat.o(194204);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static final class b
    extends RecyclerView.v
  {
    TextView gCd;
    View gvQ;
    CdnImageView gwQ;
    TextView gxs;
    TextView gxt;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(194205);
      this.gvQ = paramView;
      this.gwQ = ((CdnImageView)paramView.findViewById(2131298302));
      this.gCd = ((TextView)paramView.findViewById(2131298313));
      this.gxs = ((TextView)paramView.findViewById(2131298310));
      this.gxt = ((TextView)paramView.findViewById(2131298312));
      AppMethodBeat.o(194205);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */