package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  private String jaK;
  private int jaR;
  private Button jbb;
  private LinearLayout jbh;
  private RecyclerView jbj;
  private LinearLayoutManager jbn;
  private ManagerRoomByWeworkUI.b jbp;
  private String jmc;
  private ArrayList<String> jmd;
  private ArrayList<String> jme;
  private ImageView jmf;
  private Button jmg;
  private a jmh;
  private TextView titleTv;
  
  public static void cn(Context paramContext)
  {
    AppMethodBeat.i(193914);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(193914);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(193914);
  }
  
  public int getLayoutId()
  {
    return a.f.jeu;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(182222);
    super.initView();
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.b.BG_2));
    setBackGroundColorResource(a.b.BG_2);
    setMMTitle("");
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.jmf = ((ImageView)findViewById(a.e.icon));
    this.titleTv = ((TextView)findViewById(a.e.jcF));
    this.jbh = ((LinearLayout)findViewById(a.e.jcH));
    this.jbj = ((RecyclerView)findViewById(a.e.jck));
    this.jbb = ((Button)findViewById(a.e.finish_button));
    this.jmg = ((Button)findViewById(a.e.jcG));
    if (this.jaR == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jmf.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 48);
      this.jmf.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(a.e.jcE).setVisibility(8);
      this.jbj.setVisibility(0);
      this.jbn = new LinearLayoutManager();
      this.jbn.setOrientation(1);
      this.jbj.setLayoutManager(this.jbn);
      this.jbp = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.jbj.a(this.jbp);
      this.jmh = new a(getContext(), this.jmd, this.jme);
      this.jbj.setAdapter(this.jmh);
      this.jmh.alc.notifyChanged();
      this.jbb.setVisibility(8);
      this.jmg.setVisibility(0);
      this.jmg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.cn(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(a.e.jcE)).setText(this.jmc);
    this.jbj.setVisibility(8);
    this.jbb.setVisibility(0);
    this.jmg.setVisibility(8);
    this.jbb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191103);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        c.f(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191103);
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
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jaR = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.jaR) });
    if ((this.jaR != 3) && (Util.isNullOrNil(this.jaK)))
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.jmc = getIntent().getStringExtra("popup_wording");
      this.jmd = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.jme = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private List<as> jbu;
    private ArrayList<String> jmd;
    private ArrayList<String> jme;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(187728);
      this.context = paramContext;
      this.jmd = paramArrayList1;
      this.jme = paramArrayList2;
      this.jbu = new ArrayList();
      paramContext = this.jmd.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((n)h.ae(n.class)).bbL().RG(paramArrayList1);
        this.jbu.add(paramArrayList1);
      }
      paramContext = this.jme.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((n)h.ae(n.class)).bbL().RG(paramArrayList1);
        this.jbu.add(paramArrayList1);
      }
      AppMethodBeat.o(187728);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(187729);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.jet, paramViewGroup, false));
      AppMethodBeat.o(187729);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(187732);
      if ((this.jbu != null) && (paramInt >= 0) && (paramInt < this.jbu.size()))
      {
        paramv = (WeworkRoomUpgradeResultUI.b)paramv;
        as localas = (as)this.jbu.get(paramInt);
        Log.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localas.field_username });
        paramv.jac.setVisibility(0);
        ManagerRoomByWeworkUI.a(localas.field_username, paramv.jbd);
        if (this.jmd.contains(localas.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.jbF, paramv.jbG, true);
          paramv.jmj.setVisibility(8);
          AppMethodBeat.o(187732);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.jbF, paramv.jbG, false);
        paramv.jmj.setVisibility(0);
        paramv.jmj.setText(a.i.jhh);
      }
      AppMethodBeat.o(187732);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(187735);
      int i = this.jbu.size();
      AppMethodBeat.o(187735);
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
    View jac;
    TextView jbF;
    TextView jbG;
    CdnImageView jbd;
    TextView jmj;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(193992);
      this.jac = paramView;
      this.jbd = ((CdnImageView)paramView.findViewById(a.e.jcu));
      this.jmj = ((TextView)paramView.findViewById(a.e.jcC));
      this.jbF = ((TextView)paramView.findViewById(a.e.jcz));
      this.jbG = ((TextView)paramView.findViewById(a.e.jcB));
      AppMethodBeat.o(193992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */