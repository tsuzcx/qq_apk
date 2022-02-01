package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.b;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.r;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fTI;
  private String fPi;
  private MMLoadMoreListView fTE;
  private a fTF;
  private String fTG;
  private int fTH = 0;
  private View fTk;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    fTI = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.yr(paramString1);
    Object localObject;
    switch (paramInt1)
    {
    default: 
      localObject = str;
    case 1: 
    case 34: 
    case 3: 
    case 23: 
    case 33: 
    case 43: 
    case 62: 
    case 486539313: 
    case 48: 
    case 42: 
    case 66: 
      label272:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.sv(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131755853);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131762242, new Object[] { ((l)g.ab(l.class)).dlK().aql(paramString1).label });
        }
        localObject = str;
      } while (bt.nullAsNil(paramString1).length() <= 0);
      localObject = bj.Bk(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((l)g.ab(l.class)).dlK().aqk(paramString1);
      paramString2 = ((l)g.ab(l.class)).azp().Bf(paramString2).adv();
      paramString1 = paramString2;
      if (w.vF(paramString2)) {
        paramString1 = q.ae(q.yT(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131759492, new Object[] { paramString1, ((bu.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131759493, new Object[] { paramString1, ((bu.a)localObject).getDisplayName() });
      break;
      if (localb == null)
      {
        ad.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        AppMethodBeat.o(12989);
        return "";
      }
      localObject = str;
      switch (localb.type)
      {
      case 7: 
      default: 
        localObject = "";
        break;
      case 6: 
        localObject = paramContext.getString(2131762239, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(2131762253, new Object[] { localb.getTitle() });
        break;
      case 8: 
        localObject = paramContext.getString(2131755723);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131755722);
        break;
      case 25: 
        localObject = paramContext.getString(2131755710);
        break;
      case 17: 
        localObject = paramContext.getString(2131762242, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(2131762245, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.hAs;
        if (bt.isNullOrNil(paramString2))
        {
          ad.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1142;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131762244, new Object[] { bt.bI(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)fTI.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            ad.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label922;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = bw.M(paramString2, "recordinfo");; paramString1 = bw.M("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label1067;
            }
            ad.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.xqw = ((String)paramString1.get(".recordinfo.favusername"));
          fTI.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label922;
        }
      case 3: 
        localObject = paramContext.getString(2131762243, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(2131762254, new Object[] { localb.title });
        break;
      case 2: 
        localObject = paramContext.getString(2131755853);
        break;
      case 1: 
      case 53: 
      case 57: 
        localObject = localb.title;
        break;
      case 33: 
      case 36: 
      case 44: 
      case 48: 
        label922:
        label1067:
        label1142:
        if (bt.isNullOrNil(localb.title))
        {
          localObject = paramContext.getString(2131766379, new Object[] { "" });
          break;
        }
        localObject = paramContext.getString(2131766379, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131755722);
        break;
        localObject = paramContext.getString(2131762246);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.hAU)
          {
          case 2: 
          default: 
            localObject = bt.nullAsNil(localb.title);
            break label272;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756072);
          break;
        }
        localObject = paramContext.getString(2131756075);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756073);
          break;
        }
        localObject = paramContext.getString(2131756070);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756074);
          break;
        }
        localObject = paramContext.getString(2131756071);
        break;
        if (localb == null)
        {
          ad.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hBu, localb.hBr });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hBu, localb.hBq });
        break;
        if (localb == null)
        {
          ad.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hBu, localb.hBI });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hBu, localb.hBH });
        break;
        localObject = paramContext.getString(2131762235, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131762235, new Object[] { "" });
        break;
        localObject = paramContext.getString(2131762233, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131762248, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = bu.d.aUe(paramString1);
        localObject = str;
        if (paramString1.dHm == null) {
          break;
        }
        localObject = str;
        if (paramString1.dHm.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(2131759578, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(2131759559, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(2131759569, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(2131759491, new Object[] { paramString1.getDisplayName() });
          break;
          localObject = paramContext.getString(2131766955, new Object[] { localb.title });
          break;
          paramString2 = paramContext.getString(2131755775);
          localObject = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramString1 = paramString2;
            if (((com.tencent.mm.plugin.i.a.b)localObject).inc != null)
            {
              paramString1 = paramString2;
              if (!bt.isNullOrNil(((com.tencent.mm.plugin.i.a.b)localObject).inc.nickname))
              {
                localObject = paramString2 + paramContext.getString(2131766954, new Object[] { ((com.tencent.mm.plugin.i.a.b)localObject).inc.nickname });
                break;
                paramContext = paramContext.getString(2131755775);
                paramString2 = (com.tencent.mm.plugin.i.a.c)localb.ao(com.tencent.mm.plugin.i.a.c.class);
                paramString1 = paramContext;
                if (paramString2 != null)
                {
                  paramString1 = paramContext;
                  if (paramString2.ind != null)
                  {
                    paramString1 = paramContext;
                    if (!bt.isNullOrNil(paramString2.ind.dzZ))
                    {
                      if (paramString2.ind.sMj == 1)
                      {
                        localObject = paramContext + aj.getContext().getString(2131766953, new Object[] { paramString2.ind.dzZ });
                        break;
                      }
                      localObject = paramContext + paramString2.ind.dzZ;
                      break;
                    }
                  }
                }
              }
            }
          }
          localObject = paramString1;
          break;
          paramString2 = (String)localObject;
        }
        break;
      }
    }
  }
  
  protected static String a(ab paramab, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramab == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramab = paramab.zf(paramString);
    AppMethodBeat.o(12988);
    return paramab;
  }
  
  public int getLayoutId()
  {
    return 2131495350;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    setMMTitle(bt.nullAsNil(this.mTitle));
    this.fTE = ((MMLoadMoreListView)findViewById(2131302228));
    this.fTE.fyL();
    this.fTF = new a(this, this.fPi, this.fTG, this.fTH);
    this.fTE.setAdapter(this.fTF);
    this.fTk = findViewById(2131304525);
    if (this.fTH == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.fTk.setVisibility(0);
        this.fTE.setVisibility(8);
      }
      this.fTE.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(12977);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = (bu)SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(12977);
        }
      });
      this.fTE.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void Zt()
        {
          AppMethodBeat.i(12978);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this);
            locala.fTL -= 16;
            if ((bt.isNullOrNil(SelectedMemberChattingRecordUI.c(locala.fTJ))) || (!u.za(SelectedMemberChattingRecordUI.c(locala.fTJ)))) {
              break label113;
            }
            locala.setCursor(((l)g.ab(l.class)).dlK().el(locala.fTa, locala.fTM - locala.fTL));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(12978);
            return;
            label113:
            if (!u.za(SelectedMemberChattingRecordUI.c(locala.fTJ))) {
              locala.setCursor(((l)g.ab(l.class)).dlK().ab(locala.fTa, locala.fTK, locala.fTM - locala.fTL));
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12979);
          SelectedMemberChattingRecordUI.this.setResult(0);
          SelectedMemberChattingRecordUI.this.finish();
          AppMethodBeat.o(12979);
          return true;
        }
      });
      AppMethodBeat.o(12987);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12986);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fTG = getIntent().getStringExtra("room_member");
    ad.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.fPi });
    this.mTitle = getIntent().getStringExtra("title");
    if ((!bt.isNullOrNil(this.fTG)) && (u.za(this.fTG))) {
      this.fTH = ((l)g.ab(l.class)).dlK().aqt(this.fPi);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(12986);
      return;
      if (!u.za(this.fTG)) {
        this.fTH = ((l)g.ab(l.class)).dlK().hS(this.fPi, this.fTG);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends r<bu>
  {
    String fTK;
    int fTL;
    int fTM;
    private ab fTN;
    String fTa;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new bu());
      AppMethodBeat.i(12980);
      this.fTL = -1;
      this.fTM = -1;
      this.mContext = paramContext;
      this.fTM = paramInt;
      this.fTa = paramString1;
      this.fTK = paramString2;
      this.fTN = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AO(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(k.c(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(12981);
      if ((this.fTL < 0) || (this.fTL > this.fTM)) {
        this.fTL = (this.fTM - 16);
      }
      if ((!bt.isNullOrNil(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) && (u.za(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))))
      {
        setCursor(((l)g.ab(l.class)).dlK().el(this.fTa, this.fTM - this.fTL));
        AppMethodBeat.o(12981);
        return;
      }
      if (!u.za(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) {
        setCursor(((l)g.ab(l.class)).dlK().ab(this.fTa, this.fTK, this.fTM - this.fTL));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(12982);
      Zu();
      AppMethodBeat.o(12982);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12983);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(2131494753, null, false);
        paramView = new SelectedMemberChattingRecordUI.b((byte)0);
        paramView.fOf = ((ImageView)paramViewGroup.findViewById(2131297008));
        paramView.fOg = ((TextView)paramViewGroup.findViewById(2131302867));
        paramView.fTO = ((TextView)paramViewGroup.findViewById(2131302555));
        paramView.fTP = ((TextView)paramViewGroup.findViewById(2131306207));
        paramViewGroup.setTag(paramView);
      }
      bu localbu = (bu)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.fOf, this.fTK);
      paramView = this.fTK;
      Object localObject2 = ((l)g.ab(l.class)).azp().Bf(paramView);
      if (!bt.isNullOrNil(((aw)localObject2).field_conRemark))
      {
        paramView = ((aw)localObject2).field_conRemark;
        if (!bt.isNullOrNil(paramView)) {
          break label344;
        }
        paramView = ((am)localObject2).adu();
      }
      label344:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type))
        {
          localObject2 = ((l)g.ab(l.class)).azq().aqz(((aw)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!bt.isNullOrNil(((cf)localObject2).field_conRemark)) {
              localObject1 = ((cf)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.fOg);
        paramView = this.fTK;
        a(SelectedMemberChattingRecordUI.a(aj.getContext(), localbu.getType(), localbu.field_content, paramView, localbu.field_isSend).trim(), localb.fTO);
        a(com.tencent.mm.pluginsdk.i.i.c(SelectedMemberChattingRecordUI.this, localbu.field_createTime, true), localb.fTP);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.fTN, ((aw)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView fTO;
    public TextView fTP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */