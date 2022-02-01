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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private ImageView fBA;
  private Button fBB;
  private a fBC;
  private String fBx;
  private ArrayList<String> fBy;
  private ArrayList<String> fBz;
  private String fvZ;
  private ManagerRoomByWeworkUI.b fwA;
  private int fwc;
  private Button fwm;
  private LinearLayout fws;
  private RecyclerView fwu;
  private LinearLayoutManager fwy;
  private TextView titleTv;
  
  public static void bW(Context paramContext)
  {
    AppMethodBeat.i(197149);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(197149);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(197149);
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
    this.fBA = ((ImageView)findViewById(2131300874));
    this.titleTv = ((TextView)findViewById(2131298777));
    this.fws = ((LinearLayout)findViewById(2131307196));
    this.fwu = ((RecyclerView)findViewById(2131307150));
    this.fwm = ((Button)findViewById(2131300102));
    this.fBB = ((Button)findViewById(2131307195));
    if (this.fwc == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fBA.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 48);
      this.fBA.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(2131298754).setVisibility(8);
      this.fwu.setVisibility(0);
      this.fwy = new LinearLayoutManager();
      this.fwy.setOrientation(1);
      this.fwu.setLayoutManager(this.fwy);
      this.fwA = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.fwu.a(this.fwA);
      this.fBC = new a(getContext(), this.fBy, this.fBz);
      this.fwu.setAdapter(this.fBC);
      this.fBC.arg.notifyChanged();
      this.fwm.setVisibility(8);
      this.fBB.setVisibility(0);
      this.fBB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          ac.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.bW(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(2131298754)).setText(this.fBx);
    this.fwu.setVisibility(8);
    this.fwm.setVisibility(0);
    this.fBB.setVisibility(8);
    this.fwm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197143);
        ac.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        d.e(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        AppMethodBeat.o(197143);
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
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fwc = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    ac.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fwc) });
    if ((this.fwc != 3) && (bs.isNullOrNil(this.fvZ)))
    {
      ac.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.fBx = getIntent().getStringExtra("popup_wording");
      this.fBy = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.fBz = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private ArrayList<String> fBy;
    private ArrayList<String> fBz;
    private List<ai> fwF;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(197144);
      this.context = paramContext;
      this.fBy = paramArrayList1;
      this.fBz = paramArrayList2;
      this.fwF = new ArrayList();
      paramContext = this.fBy.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((k)g.ab(k.class)).awB().aNt(paramArrayList1);
        this.fwF.add(paramArrayList1);
      }
      paramContext = this.fBz.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((k)g.ab(k.class)).awB().aNt(paramArrayList1);
        this.fwF.add(paramArrayList1);
      }
      AppMethodBeat.o(197144);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(197145);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496162, paramViewGroup, false));
      AppMethodBeat.o(197145);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(197146);
      if ((this.fwF != null) && (paramInt >= 0) && (paramInt < this.fwF.size()))
      {
        paramw = (WeworkRoomUpgradeResultUI.b)paramw;
        ai localai = (ai)this.fwF.get(paramInt);
        ac.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localai.field_username });
        paramw.fvu.setVisibility(0);
        ManagerRoomByWeworkUI.a(localai.field_username, paramw.fwo);
        if (this.fBy.contains(localai.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localai.field_username, paramw.fwQ, paramw.fwR, true);
          paramw.fBE.setVisibility(8);
          AppMethodBeat.o(197146);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localai.field_username, paramw.fwQ, paramw.fwR, false);
        paramw.fBE.setVisibility(0);
        paramw.fBE.setText(2131766409);
      }
      AppMethodBeat.o(197146);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(197147);
      int i = this.fwF.size();
      AppMethodBeat.o(197147);
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
    TextView fBE;
    View fvu;
    TextView fwQ;
    TextView fwR;
    CdnImageView fwo;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(197148);
      this.fvu = paramView;
      this.fwo = ((CdnImageView)paramView.findViewById(2131307168));
      this.fBE = ((TextView)paramView.findViewById(2131307171));
      this.fwQ = ((TextView)paramView.findViewById(2131307169));
      this.fwR = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(197148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */