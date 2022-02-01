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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private LinearLayout fPF;
  private RecyclerView fPH;
  private LinearLayoutManager fPL;
  private ManagerRoomByWeworkUI.b fPN;
  private String fPi;
  private int fPp;
  private Button fPz;
  private String fUK;
  private ArrayList<String> fUL;
  private ArrayList<String> fUM;
  private ImageView fUN;
  private Button fUO;
  private a fUP;
  private TextView titleTv;
  
  public static void bU(Context paramContext)
  {
    AppMethodBeat.i(213571);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(213571);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(213571);
  }
  
  public int getLayoutId()
  {
    return 2131496105;
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
    this.fUN = ((ImageView)findViewById(2131300874));
    this.titleTv = ((TextView)findViewById(2131298777));
    this.fPF = ((LinearLayout)findViewById(2131307196));
    this.fPH = ((RecyclerView)findViewById(2131307150));
    this.fPz = ((Button)findViewById(2131300102));
    this.fUO = ((Button)findViewById(2131307195));
    if (this.fPp == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fUN.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 48);
      this.fUN.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(2131298754).setVisibility(8);
      this.fPH.setVisibility(0);
      this.fPL = new LinearLayoutManager();
      this.fPL.setOrientation(1);
      this.fPH.setLayoutManager(this.fPL);
      this.fPN = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.fPH.a(this.fPN);
      this.fUP = new a(getContext(), this.fUL, this.fUM);
      this.fPH.setAdapter(this.fUP);
      this.fUP.asY.notifyChanged();
      this.fPz.setVisibility(8);
      this.fUO.setVisibility(0);
      this.fUO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.bU(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(2131298754)).setText(this.fUK);
    this.fPH.setVisibility(8);
    this.fPz.setVisibility(0);
    this.fUO.setVisibility(8);
    this.fPz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213565);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        d.f(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213565);
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
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fPp = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fPp) });
    if ((this.fPp != 3) && (bt.isNullOrNil(this.fPi)))
    {
      ad.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.fUK = getIntent().getStringExtra("popup_wording");
      this.fUL = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.fUM = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private List<am> fPS;
    private ArrayList<String> fUL;
    private ArrayList<String> fUM;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(213566);
      this.context = paramContext;
      this.fUL = paramArrayList1;
      this.fUM = paramArrayList2;
      this.fPS = new ArrayList();
      paramContext = this.fUL.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.ab(l.class)).azp().Bf(paramArrayList1);
        this.fPS.add(paramArrayList1);
      }
      paramContext = this.fUM.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.ab(l.class)).azp().Bf(paramArrayList1);
        this.fPS.add(paramArrayList1);
      }
      AppMethodBeat.o(213566);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(213567);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496162, paramViewGroup, false));
      AppMethodBeat.o(213567);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(213568);
      if ((this.fPS != null) && (paramInt >= 0) && (paramInt < this.fPS.size()))
      {
        paramw = (WeworkRoomUpgradeResultUI.b)paramw;
        am localam = (am)this.fPS.get(paramInt);
        ad.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localam.field_username });
        paramw.fOB.setVisibility(0);
        ManagerRoomByWeworkUI.a(localam.field_username, paramw.fPB);
        if (this.fUL.contains(localam.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localam.field_username, paramw.fQd, paramw.fQe, true);
          paramw.fUR.setVisibility(8);
          AppMethodBeat.o(213568);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localam.field_username, paramw.fQd, paramw.fQe, false);
        paramw.fUR.setVisibility(0);
        paramw.fUR.setText(2131766409);
      }
      AppMethodBeat.o(213568);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(213569);
      int i = this.fPS.size();
      AppMethodBeat.o(213569);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static final class b
    extends RecyclerView.w
  {
    View fOB;
    CdnImageView fPB;
    TextView fQd;
    TextView fQe;
    TextView fUR;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(213570);
      this.fOB = paramView;
      this.fPB = ((CdnImageView)paramView.findViewById(2131307168));
      this.fUR = ((TextView)paramView.findViewById(2131307171));
      this.fQd = ((TextView)paramView.findViewById(2131307169));
      this.fQe = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(213570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */