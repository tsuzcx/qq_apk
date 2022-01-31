package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.q.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AASelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private HashSet<String> gpP;
  private HashSet<String> gpQ;
  private long gpR;
  private int gpS;
  private CheckBox gpT;
  private View gpU;
  private String title;
  
  private void Km()
  {
    AppMethodBeat.i(40763);
    if (this.gpQ.size() > 0) {
      updateOptionMenuText(1, getString(2131296350, new Object[] { Integer.valueOf(this.gpQ.size()) }));
    }
    while ((this.gpQ.size() == 1) && (this.gpQ.contains(r.Zn())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(40763);
      return;
      updateOptionMenuText(1, getString(2131297018));
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(40763);
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(40755);
    super.Kc();
    this.title = getIntent().getStringExtra("titile");
    this.gpR = getIntent().getLongExtra("max_select_num", 20L);
    this.gpS = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!t.lA(this.chatroomName)) {
      ab.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.gpQ = new HashSet();
    this.gpP = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil(str)) {
      this.gpP.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bo.isNullOrNil(str))
    {
      this.gpQ.addAll(bo.P(str.split(",")));
      Km();
    }
    this.gpT = ((CheckBox)findViewById(2131820921));
    this.gpU = findViewById(2131820920);
    this.gpU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40749);
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.dLW().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
          AppMethodBeat.o(40749);
          return;
          AASelectContactUI.a(AASelectContactUI.this, new HashSet());
          break;
          paramAnonymousView = com.tencent.mm.plugin.aa.a.h.wG(AASelectContactUI.c(AASelectContactUI.this));
          if (paramAnonymousView.size() > AASelectContactUI.d(AASelectContactUI.this)) {
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131296386, new Object[] { Long.valueOf(AASelectContactUI.d(AASelectContactUI.this)) }), "", new AASelectContactUI.1.1(this, paramAnonymousView), new AASelectContactUI.1.2(this));
          } else {
            AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
          }
        }
      }
    });
    if (this.gpQ.size() == com.tencent.mm.plugin.aa.a.h.wG(this.chatroomName).size()) {
      this.gpT.setChecked(true);
    }
    for (;;)
    {
      this.gpT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(40750);
          AASelectContactUI.e(AASelectContactUI.this);
          AppMethodBeat.o(40750);
        }
      });
      AppMethodBeat.o(40755);
      return;
      this.gpT.setChecked(false);
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(40761);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(40761);
      return bool;
    }
    AppMethodBeat.o(40761);
    return false;
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    return this.title;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(40758);
    d locald = new d(this, this.chatroomName);
    AppMethodBeat.o(40758);
    return locald;
  }
  
  public final n ape()
  {
    AppMethodBeat.i(40759);
    e locale = new e(this, this.chatroomName);
    AppMethodBeat.o(40759);
    return locale;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(40762);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpP.contains(parama.contact.field_username);
      AppMethodBeat.o(40762);
      return bool;
    }
    AppMethodBeat.o(40762);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130968582;
  }
  
  public void initView()
  {
    AppMethodBeat.i(40756);
    super.initView();
    addTextOptionMenu(1, getString(2131297018), new AASelectContactUI.3(this), null, q.b.zby);
    Km();
    this.oCs.setOnContactDeselectListener(this);
    setBackBtn(new AASelectContactUI.4(this));
    AppMethodBeat.o(40756);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(40760);
    o localo = dLW();
    Object localObject = localo.Qt(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(40760);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(40760);
      return;
    }
    ab.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    if (((String)localObject).equals(r.Zn()))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      dMc();
      if (!this.gpQ.contains(localObject)) {
        break label216;
      }
      this.gpQ.remove(localObject);
      label141:
      if (this.gpQ.size() != com.tencent.mm.plugin.aa.a.h.wG(this.chatroomName).size()) {
        break label228;
      }
      this.gpT.setChecked(true);
    }
    for (;;)
    {
      localo.notifyDataSetChanged();
      Km();
      AppMethodBeat.o(40760);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label216:
      this.gpQ.add(localObject);
      break label141;
      label228:
      this.gpT.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40757);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil(paramBundle)) {
      this.gpP.addAll(bo.P(paramBundle.split(",")));
    }
    AppMethodBeat.o(40757);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(40764);
    this.gpQ.remove(paramString);
    dLW().notifyDataSetChanged();
    AppMethodBeat.o(40764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */