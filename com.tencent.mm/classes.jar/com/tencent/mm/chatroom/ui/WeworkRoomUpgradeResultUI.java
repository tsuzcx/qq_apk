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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private Button fRF;
  private LinearLayout fRL;
  private RecyclerView fRN;
  private LinearLayoutManager fRR;
  private ManagerRoomByWeworkUI.b fRT;
  private String fRo;
  private int fRv;
  private String fWQ;
  private ArrayList<String> fWR;
  private ArrayList<String> fWS;
  private ImageView fWT;
  private Button fWU;
  private a fWV;
  private TextView titleTv;
  
  public static void bW(Context paramContext)
  {
    AppMethodBeat.i(217288);
    if (paramContext == null)
    {
      ae.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(217288);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217288);
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
    this.fWT = ((ImageView)findViewById(2131300874));
    this.titleTv = ((TextView)findViewById(2131298777));
    this.fRL = ((LinearLayout)findViewById(2131307196));
    this.fRN = ((RecyclerView)findViewById(2131307150));
    this.fRF = ((Button)findViewById(2131300102));
    this.fWU = ((Button)findViewById(2131307195));
    if (this.fRv == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fWT.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 48);
      this.fWT.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(2131298754).setVisibility(8);
      this.fRN.setVisibility(0);
      this.fRR = new LinearLayoutManager();
      this.fRR.setOrientation(1);
      this.fRN.setLayoutManager(this.fRR);
      this.fRT = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.fRN.a(this.fRT);
      this.fWV = new a(getContext(), this.fWR, this.fWS);
      this.fRN.setAdapter(this.fWV);
      this.fWV.asY.notifyChanged();
      this.fRF.setVisibility(8);
      this.fWU.setVisibility(0);
      this.fWU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.bW(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(2131298754)).setText(this.fWQ);
    this.fRN.setVisibility(8);
    this.fRF.setVisibility(0);
    this.fWU.setVisibility(8);
    this.fRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(217282);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        d.f(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(217282);
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
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fRv = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    ae.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fRv) });
    if ((this.fRv != 3) && (bu.isNullOrNil(this.fRo)))
    {
      ae.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.fWQ = getIntent().getStringExtra("popup_wording");
      this.fWR = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.fWS = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private List<an> fRY;
    private ArrayList<String> fWR;
    private ArrayList<String> fWS;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(217283);
      this.context = paramContext;
      this.fWR = paramArrayList1;
      this.fWS = paramArrayList2;
      this.fRY = new ArrayList();
      paramContext = this.fWR.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.ab(l.class)).azF().BH(paramArrayList1);
        this.fRY.add(paramArrayList1);
      }
      paramContext = this.fWS.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((l)g.ab(l.class)).azF().BH(paramArrayList1);
        this.fRY.add(paramArrayList1);
      }
      AppMethodBeat.o(217283);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(217284);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496162, paramViewGroup, false));
      AppMethodBeat.o(217284);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(217285);
      if ((this.fRY != null) && (paramInt >= 0) && (paramInt < this.fRY.size()))
      {
        paramw = (WeworkRoomUpgradeResultUI.b)paramw;
        an localan = (an)this.fRY.get(paramInt);
        ae.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localan.field_username });
        paramw.fQH.setVisibility(0);
        ManagerRoomByWeworkUI.a(localan.field_username, paramw.fRH);
        if (this.fWR.contains(localan.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localan.field_username, paramw.fSj, paramw.fSk, true);
          paramw.fWX.setVisibility(8);
          AppMethodBeat.o(217285);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localan.field_username, paramw.fSj, paramw.fSk, false);
        paramw.fWX.setVisibility(0);
        paramw.fWX.setText(2131766409);
      }
      AppMethodBeat.o(217285);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(217286);
      int i = this.fRY.size();
      AppMethodBeat.o(217286);
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
    View fQH;
    CdnImageView fRH;
    TextView fSj;
    TextView fSk;
    TextView fWX;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(217287);
      this.fQH = paramView;
      this.fRH = ((CdnImageView)paramView.findViewById(2131307168));
      this.fWX = ((TextView)paramView.findViewById(2131307171));
      this.fSj = ((TextView)paramView.findViewById(2131307169));
      this.fSk = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(217287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */