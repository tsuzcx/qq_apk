package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> eka;
  private String egF;
  private View ejB;
  private MMLoadMoreListView ejW;
  private SelectedMemberChattingRecordUI.a ejX;
  private String ejY;
  private int ejZ = 0;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(104450);
    eka = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(104450);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(104448);
    String str = "";
    j.b localb = j.b.mY(paramString1);
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
    case 48: 
    case 42: 
    case 66: 
      label224:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(104448);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131302366, new Object[] { Integer.valueOf((int)s.hi(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131297036);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131297077;; paramInt1 = 2131297102)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131302357, new Object[] { ((j)g.E(j.class)).bPQ().Tz(paramString1).label });
        }
        localObject = str;
      } while (bo.nullAsNil(paramString1).length() <= 0);
      localObject = bf.pu(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((j)g.E(j.class)).bPQ().Ty(paramString1);
      paramString2 = ((j)g.E(j.class)).YA().arw(paramString2).Of();
      paramString1 = paramString2;
      if (t.lA(paramString2)) {
        paramString1 = n.Q(n.nw(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131300025, new Object[] { paramString1, ((bi.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131300026, new Object[] { paramString1, ((bi.a)localObject).getDisplayName() });
      break;
      if (localb == null)
      {
        ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        AppMethodBeat.o(104448);
        return "";
      }
      localObject = str;
      switch (localb.type)
      {
      case 7: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
      case 18: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      default: 
        localObject = "";
        break;
      case 6: 
        localObject = paramContext.getString(2131302354, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(2131302364, new Object[] { localb.getTitle() });
        break;
      case 8: 
        localObject = paramContext.getString(2131296916);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131296915);
        break;
      case 25: 
        localObject = paramContext.getString(2131296903);
        break;
      case 17: 
        localObject = paramContext.getString(2131302357, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(2131302360, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.fhc;
        if (bo.isNullOrNil(paramString2))
        {
          ab.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1028;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131302359, new Object[] { bo.bf(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)eka.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            ab.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label810;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = br.F(paramString2, "recordinfo");; paramString1 = br.F("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label953;
            }
            ab.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.wjU = ((String)paramString1.get(".recordinfo.favusername"));
          eka.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label810;
        }
      case 3: 
        localObject = paramContext.getString(2131302358, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(2131302365, new Object[] { localb.title });
        break;
      case 2: 
        label810:
        label953:
        localObject = paramContext.getString(2131297036);
        label1028:
        break;
        localObject = paramContext.getString(2131296915);
        break;
        localObject = paramContext.getString(2131302361);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.fhD)
          {
          case 2: 
          default: 
            localObject = bo.nullAsNil(localb.title);
            break label224;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131297205);
          break;
        }
        localObject = paramContext.getString(2131297208);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131297206);
          break;
        }
        localObject = paramContext.getString(2131297203);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131297207);
          break;
        }
        localObject = paramContext.getString(2131297204);
        break;
        if (localb == null)
        {
          ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(104448);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131302351, new Object[] { localb.fie, localb.fib });
          break;
        }
        localObject = paramContext.getString(2131302351, new Object[] { localb.fie, localb.fia });
        break;
        if (localb == null)
        {
          ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(104448);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131302351, new Object[] { localb.fie, localb.fis });
          break;
        }
        localObject = paramContext.getString(2131302351, new Object[] { localb.fie, localb.fir });
        break;
        localObject = paramContext.getString(2131302352, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131302352, new Object[] { "" });
        break;
        localObject = paramContext.getString(2131302350, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131302363, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = bi.d.asm(paramString1);
        localObject = str;
        if (paramString1.tac == null) {
          break;
        }
        localObject = str;
        if (paramString1.tac.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(2131300111, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(2131300092, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(2131300102, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(2131300024, new Object[] { paramString1.getDisplayName() });
          break;
          paramString2 = (String)localObject;
        }
        break;
      }
    }
  }
  
  protected static String a(u paramu, String paramString)
  {
    AppMethodBeat.i(104447);
    if (paramu == null)
    {
      AppMethodBeat.o(104447);
      return null;
    }
    paramu = paramu.nE(paramString);
    AppMethodBeat.o(104447);
    return paramu;
  }
  
  public int getLayoutId()
  {
    return 2130970655;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104446);
    super.initView();
    setMMTitle(bo.nullAsNil(this.mTitle));
    this.ejW = ((MMLoadMoreListView)findViewById(2131827538));
    this.ejW.dDY();
    this.ejX = new SelectedMemberChattingRecordUI.a(this, this, this.egF, this.ejY, this.ejZ);
    this.ejW.setAdapter(this.ejX);
    this.ejB = findViewById(2131827539);
    if (this.ejZ == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ejB.setVisibility(0);
        this.ejW.setVisibility(8);
      }
      this.ejW.setOnItemClickListener(new SelectedMemberChattingRecordUI.1(this));
      this.ejW.setOnLoadMoreListener(new SelectedMemberChattingRecordUI.2(this));
      setBackBtn(new SelectedMemberChattingRecordUI.3(this));
      AppMethodBeat.o(104446);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104445);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.ejY = getIntent().getStringExtra("room_member");
    ab.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.egF });
    this.mTitle = getIntent().getStringExtra("title");
    if ((!bo.isNullOrNil(this.ejY)) && (r.nB(this.ejY))) {
      this.ejZ = ((j)g.E(j.class)).bPQ().TH(this.egF);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(104445);
      return;
      if (!r.nB(this.ejY)) {
        this.ejZ = ((j)g.E(j.class)).bPQ().fk(this.egF, this.ejY);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */