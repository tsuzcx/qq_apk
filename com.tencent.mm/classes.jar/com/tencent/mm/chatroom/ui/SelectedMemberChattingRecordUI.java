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
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fwL;
  private String fss;
  private MMLoadMoreListView fwH;
  private a fwI;
  private String fwJ;
  private int fwK = 0;
  private View fwn;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    fwL = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.rx(paramString1);
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
      label248:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.mI(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131755853);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131762242, new Object[] { ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agD(paramString1).label });
        }
        localObject = str;
      } while (bt.nullAsNil(paramString1).length() <= 0);
      localObject = bi.uf(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agC(paramString1);
      paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString2).ZX();
      paramString1 = paramString2;
      if (com.tencent.mm.model.w.pF(paramString2)) {
        paramString1 = com.tencent.mm.model.q.ag(com.tencent.mm.model.q.rZ(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131759492, new Object[] { paramString1, ((bl.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131759493, new Object[] { paramString1, ((bl.a)localObject).getDisplayName() });
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
        paramString2 = localb.gHI;
        if (bt.isNullOrNil(paramString2))
        {
          ad.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1118;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131762244, new Object[] { bt.by(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)fwL.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            ad.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label898;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = com.tencent.mm.sdk.platformtools.bw.K(paramString2, "recordinfo");; paramString1 = com.tencent.mm.sdk.platformtools.bw.K("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label1043;
            }
            ad.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.Csg = ((String)paramString1.get(".recordinfo.favusername"));
          fwL.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label898;
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
        label898:
        label1043:
        label1118:
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
          switch (localb.gIk)
          {
          case 2: 
          default: 
            localObject = bt.nullAsNil(localb.title);
            break label248;
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
          localObject = paramContext.getString(2131762234, new Object[] { localb.gIL, localb.gII });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.gIL, localb.gIH });
        break;
        if (localb == null)
        {
          ad.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.gIL, localb.gIZ });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.gIL, localb.gIY });
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
        paramString1 = bl.d.aIR(paramString1);
        localObject = str;
        if (paramString1.yGA == null) {
          break;
        }
        localObject = str;
        if (paramString1.yGA.length() <= 0) {
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
          paramString2 = (String)localObject;
        }
        break;
      }
    }
  }
  
  protected static String a(com.tencent.mm.storage.w paramw, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramw == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramw = paramw.sh(paramString);
    AppMethodBeat.o(12988);
    return paramw;
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
    this.fwH = ((MMLoadMoreListView)findViewById(2131302228));
    this.fwH.eSM();
    this.fwI = new a(this, this.fss, this.fwJ, this.fwK);
    this.fwH.setAdapter(this.fwI);
    this.fwn = findViewById(2131304525);
    if (this.fwK == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.fwn.setVisibility(0);
        this.fwH.setVisibility(8);
      }
      this.fwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(12977);
          paramAnonymousAdapterView = (bl)SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          AppMethodBeat.o(12977);
        }
      });
      this.fwH.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void Wc()
        {
          AppMethodBeat.i(12978);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this);
            locala.fwO -= 16;
            if ((bt.isNullOrNil(SelectedMemberChattingRecordUI.c(locala.fwM))) || (!u.se(SelectedMemberChattingRecordUI.c(locala.fwM)))) {
              break label113;
            }
            locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().dN(locala.fwd, locala.fwP - locala.fwO));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(12978);
            return;
            label113:
            if (!u.se(SelectedMemberChattingRecordUI.c(locala.fwM))) {
              locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().X(locala.fwd, locala.fwN, locala.fwP - locala.fwO));
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
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.fwJ = getIntent().getStringExtra("room_member");
    ad.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.fss });
    this.mTitle = getIntent().getStringExtra("title");
    if ((!bt.isNullOrNil(this.fwJ)) && (u.se(this.fwJ))) {
      this.fwK = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agL(this.fss);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(12986);
      return;
      if (!u.se(this.fwJ)) {
        this.fwK = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().hp(this.fss, this.fwJ);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends com.tencent.mm.ui.q<bl>
  {
    String fwN;
    int fwO;
    int fwP;
    private com.tencent.mm.storage.w fwQ;
    String fwd;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new bl());
      AppMethodBeat.i(12980);
      this.fwO = -1;
      this.fwP = -1;
      this.mContext = paramContext;
      this.fwP = paramInt;
      this.fwd = paramString1;
      this.fwN = paramString2;
      this.fwQ = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(12981);
      if ((this.fwO < 0) || (this.fwO > this.fwP)) {
        this.fwO = (this.fwP - 16);
      }
      if ((!bt.isNullOrNil(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) && (u.se(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))))
      {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().dN(this.fwd, this.fwP - this.fwO));
        AppMethodBeat.o(12981);
        return;
      }
      if (!u.se(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().X(this.fwd, this.fwN, this.fwP - this.fwO));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void We()
    {
      AppMethodBeat.i(12982);
      Wd();
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
        paramView.frr = ((ImageView)paramViewGroup.findViewById(2131297008));
        paramView.frs = ((TextView)paramViewGroup.findViewById(2131302867));
        paramView.fwR = ((TextView)paramViewGroup.findViewById(2131302555));
        paramView.fwS = ((TextView)paramViewGroup.findViewById(2131306207));
        paramViewGroup.setTag(paramView);
      }
      bl localbl = (bl)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.frr, this.fwN);
      paramView = this.fwN;
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramView);
      if (!bt.isNullOrNil(((au)localObject2).field_conRemark))
      {
        paramView = ((au)localObject2).field_conRemark;
        if (!bt.isNullOrNil(paramView)) {
          break label344;
        }
        paramView = ((af)localObject2).ZW();
      }
      label344:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!b.ls(((au)localObject2).field_type))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(((au)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!bt.isNullOrNil(((com.tencent.mm.storage.bw)localObject2).field_conRemark)) {
              localObject1 = ((com.tencent.mm.storage.bw)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.frs);
        paramView = this.fwN;
        a(SelectedMemberChattingRecordUI.a(com.tencent.mm.sdk.platformtools.aj.getContext(), localbl.getType(), localbl.field_content, paramView, localbl.field_isSend).trim(), localb.fwR);
        a(com.tencent.mm.pluginsdk.g.h.c(SelectedMemberChattingRecordUI.this, localbl.field_createTime, true), localb.fwS);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.fwQ, ((au)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public ImageView frr;
    public TextView frs;
    public TextView fwR;
    public TextView fwS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */