package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeworkRoomUpgradeResultUI
  extends MMActivity
{
  private int lCR;
  private Button lDb;
  private LinearLayout lDh;
  private RecyclerView lDj;
  private LinearLayoutManager lDn;
  private ManagerRoomByWeworkUI.b lDp;
  private String lOY;
  private ArrayList<String> lOZ;
  private ArrayList<String> lPa;
  private ImageView lPb;
  private Button lPc;
  private a lPd;
  private String lyn;
  private TextView titleTv;
  
  public static void db(Context paramContext)
  {
    AppMethodBeat.i(241641);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "gotoWeWork context null");
      AppMethodBeat.o(241641);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
    ((Intent)localObject).setPackage("com.tencent.wework");
    ((Intent)localObject).setFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI", "gotoWeWork", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241641);
  }
  
  public int getLayoutId()
  {
    return a.f.lGF;
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
    this.lPb = ((ImageView)findViewById(a.e.icon));
    this.titleTv = ((TextView)findViewById(a.e.lEG));
    this.lDh = ((LinearLayout)findViewById(a.e.lEN));
    this.lDj = ((RecyclerView)findViewById(a.e.lEk));
    this.lDb = ((Button)findViewById(a.e.finish_button));
    this.lPc = ((Button)findViewById(a.e.lEM));
    if (this.lCR == 3)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.lPb.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 48);
      this.lPb.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.titleTv.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
      this.titleTv.setLayoutParams(localLayoutParams);
      findViewById(a.e.lEF).setVisibility(8);
      this.lDj.setVisibility(0);
      this.lDn = new LinearLayoutManager();
      this.lDn.setOrientation(1);
      this.lDj.setLayoutManager(this.lDn);
      this.lDp = new ManagerRoomByWeworkUI.b(getContext(), 56.0F);
      this.lDj.a(this.lDp);
      this.lPd = new a(getContext(), this.lOZ, this.lPa);
      this.lDj.setAdapter(this.lPd);
      this.lPd.bZE.notifyChanged();
      this.lDb.setVisibility(8);
      this.lPc.setVisibility(0);
      this.lPc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182219);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "click return wework");
          WeworkRoomUpgradeResultUI.db(WeworkRoomUpgradeResultUI.this);
          WeworkRoomUpgradeResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182219);
        }
      });
      AppMethodBeat.o(182222);
      return;
    }
    ((TextView)findViewById(a.e.lEF)).setText(this.lOY);
    this.lDj.setVisibility(8);
    this.lDb.setVisibility(0);
    this.lPc.setVisibility(8);
    this.lDb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(241652);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "[goToChattingUI] username:%s", new Object[] { WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this) });
        paramAnonymousView = new Intent().putExtra("Main_User", WeworkRoomUpgradeResultUI.a(WeworkRoomUpgradeResultUI.this));
        paramAnonymousView.putExtra("From_fail_notify", true);
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.addFlags(536870912);
        c.g(WeworkRoomUpgradeResultUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousView);
        WeworkRoomUpgradeResultUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/WeworkRoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241652);
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
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lCR = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    Log.i("MicroMsg.WeworkRoomUpgradeResultUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.lCR) });
    if ((this.lCR != 3) && (Util.isNullOrNil(this.lyn)))
    {
      Log.e("MicroMsg.WeworkRoomUpgradeResultUI", "mRoomId is null");
      finish();
    }
    while (i == 0)
    {
      AppMethodBeat.o(182220);
      return;
      this.lOY = getIntent().getStringExtra("popup_wording");
      this.lOZ = getIntent().getStringArrayListExtra("wework_upgrade_success_list");
      this.lPa = getIntent().getStringArrayListExtra("wework_upgrade_fail_list");
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
    private List<au> lDu;
    private ArrayList<String> lOZ;
    private ArrayList<String> lPa;
    
    public a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    {
      AppMethodBeat.i(241513);
      this.context = paramContext;
      this.lOZ = paramArrayList1;
      this.lPa = paramArrayList2;
      this.lDu = new ArrayList();
      paramContext = this.lOZ.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((n)h.ax(n.class)).bzA().JE(paramArrayList1);
        this.lDu.add(paramArrayList1);
      }
      paramContext = this.lPa.iterator();
      while (paramContext.hasNext())
      {
        paramArrayList1 = (String)paramContext.next();
        paramArrayList1 = ((n)h.ax(n.class)).bzA().JE(paramArrayList1);
        this.lDu.add(paramArrayList1);
      }
      AppMethodBeat.o(241513);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(241518);
      paramViewGroup = new WeworkRoomUpgradeResultUI.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.lGE, paramViewGroup, false));
      AppMethodBeat.o(241518);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(241527);
      if ((this.lDu != null) && (paramInt >= 0) && (paramInt < this.lDu.size()))
      {
        paramv = (WeworkRoomUpgradeResultUI.b)paramv;
        au localau = (au)this.lDu.get(paramInt);
        Log.d("MicroMsg.WeworkRoomUpgradeResultUI", "onBindViewHolder() i:%s username:%s", new Object[] { Integer.valueOf(paramInt), localau.field_username });
        paramv.lBX.setVisibility(0);
        ManagerRoomByWeworkUI.a(localau.field_username, paramv.lDd);
        if (this.lOZ.contains(localau.field_username))
        {
          ManagerRoomByWeworkUI.a(this.context, localau.field_username, paramv.lDF, paramv.lDG, true);
          paramv.lPf.setVisibility(8);
          AppMethodBeat.o(241527);
          return;
        }
        ManagerRoomByWeworkUI.a(this.context, localau.field_username, paramv.lDF, paramv.lDG, false);
        paramv.lPf.setVisibility(0);
        paramv.lPf.setText(a.i.lJx);
      }
      AppMethodBeat.o(241527);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(241533);
      int i = this.lDu.size();
      AppMethodBeat.o(241533);
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
    View lBX;
    TextView lDF;
    TextView lDG;
    CdnImageView lDd;
    TextView lPf;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(241508);
      this.lBX = paramView;
      this.lDd = ((CdnImageView)paramView.findViewById(a.e.lEu));
      this.lPf = ((TextView)paramView.findViewById(a.e.lEC));
      this.lDF = ((TextView)paramView.findViewById(a.e.lEz));
      this.lDG = ((TextView)paramView.findViewById(a.e.lEB));
      AppMethodBeat.o(241508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.WeworkRoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */