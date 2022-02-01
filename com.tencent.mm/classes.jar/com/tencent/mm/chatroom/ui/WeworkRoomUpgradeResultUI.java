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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private Button fsF;
  private LinearLayout fsL;
  private RecyclerView fsN;
  private LinearLayoutManager fsR;
  private ManagerRoomByWeworkUI.b fsT;
  private String fss;
  private int fsv;
  private String fxQ;
  private ArrayList<String> fxR;
  private ArrayList<String> fxS;
  private ImageView fxT;
  private Button fxU;
  private a fxV;
  private TextView titleTv;
  
  public static void bT(Context paramContext)
  {
    AppMethodBeat.i(196663);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(196663);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(196663);
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
    this.fxT = ((ImageView)findViewById(2131300874));
    this.titleTv = ((TextView)findViewById(2131298777));
    this.fsL = ((LinearLayout)findViewById(2131307196));
    this.fsN = ((RecyclerView)findViewById(2131307150));
    this.fsF = ((Button)findViewById(2131300102));
    this.fxU = ((Button)findViewById(2131307195));
    if (this.fsv == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fxT.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 48);
      this.fxT.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(2131298754).setVisibility(8);
      this.fsN.setVisibility(0);
      this.fsR = new LinearLayoutManager();
      this.fsR.setOrientation(1);
      this.fsN.setLayoutManager(this.fsR);
      this.fsT = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.fsN.a(this.fsT);
      this.fxV = new a(getContext(), this.fxR, this.fxS);
      this.fsN.setAdapter(this.fxV);
      this.fxV.aql.notifyChanged();
      this.fsF.setVisibility(8);
      this.fxU.setVisibility(0);
      this.fxU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.bT(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(2131298754)).setText(this.fxQ);
    this.fsN.setVisibility(8);
    this.fsF.setVisibility(0);
    this.fxU.setVisibility(8);
    this.fsF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196657);
        ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        d.e(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        AppMethodBeat.o(196657);
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
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.fsv = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    ad.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fsv) });
    if ((this.fsv != 3) && (bt.isNullOrNil(this.fss)))
    {
      ad.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.fxQ = getIntent().getStringExtra("popup_wording");
      this.fxR = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.fxS = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private List<af> fsY;
    private ArrayList<String> fxR;
    private ArrayList<String> fxS;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(196658);
      this.context = paramContext;
      this.fxR = paramArrayList1;
      this.fxS = paramArrayList2;
      this.fsY = new ArrayList();
      paramContext = this.fxR.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((k)g.ab(k.class)).apM().aHY(paramArrayList1);
        this.fsY.add(paramArrayList1);
      }
      paramContext = this.fxS.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((k)g.ab(k.class)).apM().aHY(paramArrayList1);
        this.fsY.add(paramArrayList1);
      }
      AppMethodBeat.o(196658);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196659);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496162, paramViewGroup, false));
      AppMethodBeat.o(196659);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(196660);
      if ((this.fsY != null) && (paramInt >= 0) && (paramInt < this.fsY.size()))
      {
        paramv = (WeworkRoomUpgradeResultUI.b)paramv;
        af localaf = (af)this.fsY.get(paramInt);
        ad.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localaf.field_username });
        paramv.frN.setVisibility(0);
        ManagerRoomByWeworkUI.a(localaf.field_username, paramv.fsH);
        if (this.fxR.contains(localaf.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localaf.field_username, paramv.ftj, paramv.ftk, true);
          paramv.fxX.setVisibility(8);
          AppMethodBeat.o(196660);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localaf.field_username, paramv.ftj, paramv.ftk, false);
        paramv.fxX.setVisibility(0);
        paramv.fxX.setText(2131766409);
      }
      AppMethodBeat.o(196660);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(196661);
      int i = this.fsY.size();
      AppMethodBeat.o(196661);
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
    View frN;
    CdnImageView fsH;
    TextView ftj;
    TextView ftk;
    TextView fxX;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(196662);
      this.frN = paramView;
      this.fsH = ((CdnImageView)paramView.findViewById(2131307168));
      this.fxX = ((TextView)paramView.findViewById(2131307171));
      this.ftj = ((TextView)paramView.findViewById(2131307169));
      this.ftk = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(196662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */