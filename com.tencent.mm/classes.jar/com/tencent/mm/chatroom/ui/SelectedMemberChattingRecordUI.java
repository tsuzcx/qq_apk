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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.r;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fAs;
  private MMLoadMoreListView fAo;
  private a fAp;
  private String fAq;
  private int fAr = 0;
  private String fvZ;
  private View fzU;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    fAs = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.vA(paramString1);
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
      label256:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.qw(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131755853);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131762242, new Object[] { ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alx(paramString1).label });
        }
        localObject = str;
      } while (bs.nullAsNil(paramString1).length() <= 0);
      localObject = bi.yl(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alw(paramString1);
      paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString2).aaS();
      paramString1 = paramString2;
      if (w.sQ(paramString2)) {
        paramString1 = q.ad(q.wc(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131759492, new Object[] { paramString1, ((bo.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131759493, new Object[] { paramString1, ((bo.a)localObject).getDisplayName() });
      break;
      if (localb == null)
      {
        ac.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
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
        paramString2 = localb.hij;
        if (bs.isNullOrNil(paramString2))
        {
          ac.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1126;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131762244, new Object[] { bs.bG(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)fAs.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            ac.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label906;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = bv.L(paramString2, "recordinfo");; paramString1 = bv.L("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label1051;
            }
            ac.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.DKy = ((String)paramString1.get(".recordinfo.favusername"));
          fAs.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label906;
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
        label906:
        label1051:
        label1126:
        if (bs.isNullOrNil(localb.title))
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
          switch (localb.hiL)
          {
          case 2: 
          default: 
            localObject = bs.nullAsNil(localb.title);
            break label256;
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
          ac.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hjl, localb.hji });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hjl, localb.hjh });
        break;
        if (localb == null)
        {
          ac.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hjl, localb.hjz });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hjl, localb.hjy });
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
        paramString1 = bo.d.aOn(paramString1);
        localObject = str;
        if (paramString1.zTO == null) {
          break;
        }
        localObject = str;
        if (paramString1.zTO.length() <= 0) {
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
          localObject = paramContext.getString(2131766790, new Object[] { localb.title });
          break;
          paramString2 = (String)localObject;
        }
        break;
      }
    }
  }
  
  protected static String a(x paramx, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramx == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramx = paramx.wk(paramString);
    AppMethodBeat.o(12988);
    return paramx;
  }
  
  public int getLayoutId()
  {
    return 2131495350;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    setMMTitle(bs.nullAsNil(this.mTitle));
    this.fAo = ((MMLoadMoreListView)findViewById(2131302228));
    this.fAo.fiw();
    this.fAp = new a(this, this.fvZ, this.fAq, this.fAr);
    this.fAo.setAdapter(this.fAp);
    this.fzU = findViewById(2131304525);
    if (this.fAr == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.fzU.setVisibility(0);
        this.fAo.setVisibility(8);
      }
      this.fAo.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(12977);
          paramAnonymousAdapterView = (bo)SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          AppMethodBeat.o(12977);
        }
      });
      this.fAo.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void Xa()
        {
          AppMethodBeat.i(12978);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this);
            locala.fAv -= 16;
            if ((bs.isNullOrNil(SelectedMemberChattingRecordUI.c(locala.fAt))) || (!u.wh(SelectedMemberChattingRecordUI.c(locala.fAt)))) {
              break label113;
            }
            locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dU(locala.fzK, locala.fAw - locala.fAv));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(12978);
            return;
            label113:
            if (!u.wh(SelectedMemberChattingRecordUI.c(locala.fAt))) {
              locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().Y(locala.fzK, locala.fAu, locala.fAw - locala.fAv));
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
    ac.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fAq = getIntent().getStringExtra("room_member");
    ac.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.fvZ });
    this.mTitle = getIntent().getStringExtra("title");
    if ((!bs.isNullOrNil(this.fAq)) && (u.wh(this.fAq))) {
      this.fAr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alF(this.fvZ);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(12986);
      return;
      if (!u.wh(this.fAq)) {
        this.fAr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().hI(this.fvZ, this.fAq);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends r<bo>
  {
    String fAu;
    int fAv;
    int fAw;
    private x fAx;
    String fzK;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new bo());
      AppMethodBeat.i(12980);
      this.fAv = -1;
      this.fAw = -1;
      this.mContext = paramContext;
      this.fAw = paramInt;
      this.fzK = paramString1;
      this.fAu = paramString2;
      this.fAx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
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
    
    public final void Xb()
    {
      AppMethodBeat.i(12981);
      if ((this.fAv < 0) || (this.fAv > this.fAw)) {
        this.fAv = (this.fAw - 16);
      }
      if ((!bs.isNullOrNil(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) && (u.wh(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))))
      {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dU(this.fzK, this.fAw - this.fAv));
        AppMethodBeat.o(12981);
        return;
      }
      if (!u.wh(SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this))) {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().Y(this.fzK, this.fAu, this.fAw - this.fAv));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(12982);
      Xb();
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
        paramView.fuY = ((ImageView)paramViewGroup.findViewById(2131297008));
        paramView.fuZ = ((TextView)paramViewGroup.findViewById(2131302867));
        paramView.fAy = ((TextView)paramViewGroup.findViewById(2131302555));
        paramView.fAz = ((TextView)paramViewGroup.findViewById(2131306207));
        paramViewGroup.setTag(paramView);
      }
      bo localbo = (bo)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.fuY, this.fAu);
      paramView = this.fAu;
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramView);
      if (!bs.isNullOrNil(((av)localObject2).field_conRemark))
      {
        paramView = ((av)localObject2).field_conRemark;
        if (!bs.isNullOrNil(paramView)) {
          break label344;
        }
        paramView = ((com.tencent.mm.storage.ai)localObject2).aaR();
      }
      label344:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!b.ln(((av)localObject2).field_type))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(((av)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!bs.isNullOrNil(((bz)localObject2).field_conRemark)) {
              localObject1 = ((bz)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.fuZ);
        paramView = this.fAu;
        a(SelectedMemberChattingRecordUI.a(com.tencent.mm.sdk.platformtools.ai.getContext(), localbo.getType(), localbo.field_content, paramView, localbo.field_isSend).trim(), localb.fAy);
        a(com.tencent.mm.pluginsdk.g.h.c(SelectedMemberChattingRecordUI.this, localbo.field_createTime, true), localb.fAz);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.fAx, ((av)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public TextView fAy;
    public TextView fAz;
    public ImageView fuY;
    public TextView fuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */