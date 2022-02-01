package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private ArrayList<String> iYn;
  private ArrayList<String> iYo;
  private HashSet<String> iYp;
  private HashSet<String> iYq;
  private long iYr;
  private int iYs;
  private CheckBox iYt;
  private View iYu;
  private List<String> iYv;
  private List<String> iYw;
  private int scene;
  private String title;
  
  private void Zv()
  {
    AppMethodBeat.i(63544);
    if (this.iYq.size() > 0) {
      updateOptionMenuText(1, getString(2131755030, new Object[] { Integer.valueOf(this.iYq.size()) }));
    }
    while ((this.iYq.size() == 1) && (this.iYq.contains(v.aAC())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      updateOptionMenuText(1, getString(2131755835));
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private void aI(List<String> paramList)
  {
    AppMethodBeat.i(189738);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (an.aUq(str)) {
          this.iYw.add(str);
        } else {
          this.iYv.add(str);
        }
      }
    }
    AppMethodBeat.o(189738);
  }
  
  private boolean aRY()
  {
    return this.scene == 6;
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.iYq.remove(paramString);
      fMv().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(63536);
    super.Zm();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.iYo = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.iYr = getIntent().getLongExtra("max_select_num", 20L);
    this.iYs = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!x.wb(this.chatroomName)) {
      ae.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.iYq = new HashSet();
    this.iYp = new HashSet();
    this.iYn = new ArrayList();
    this.iYw = new ArrayList();
    this.iYv = new ArrayList();
    if (x.zW(this.chatroomName)) {
      aI(i.JC(this.chatroomName));
    }
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bu.isNullOrNil(str)) {
      this.iYp.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bu.isNullOrNil(str))
    {
      this.iYq.addAll(bu.U(str.split(",")));
      Zv();
    }
    this.iYn.addAll(this.iYq);
    this.iYt = ((CheckBox)findViewById(2131305975));
    this.iYu = findViewById(2131305976);
    this.iYu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(63530);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.fMv().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63530);
          return;
          AASelectContactUI.a(AASelectContactUI.this, new HashSet());
          break;
          if (AASelectContactUI.c(AASelectContactUI.this))
          {
            paramAnonymousView = new ArrayList();
            localObject = AASelectContactUI.d(AASelectContactUI.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramAnonymousView.add((String)((Iterator)localObject).next());
            }
          }
          for (;;)
          {
            if (paramAnonymousView.size() <= AASelectContactUI.g(AASelectContactUI.this)) {
              break label324;
            }
            h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755068, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63529);
                AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
                AppMethodBeat.o(63529);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            break;
            if (!x.zW(AASelectContactUI.e(AASelectContactUI.this))) {
              paramAnonymousView = i.JC(AASelectContactUI.e(AASelectContactUI.this));
            } else {
              paramAnonymousView = AASelectContactUI.f(AASelectContactUI.this);
            }
          }
          label324:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (aRY())
    {
      i = this.iYo.size();
      if (this.iYq.size() != i) {
        break label409;
      }
      this.iYt.setChecked(true);
    }
    for (;;)
    {
      this.iYt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(63531);
          AASelectContactUI.h(AASelectContactUI.this);
          AppMethodBeat.o(63531);
        }
      });
      AppMethodBeat.o(63536);
      return;
      if (!x.zW(this.chatroomName))
      {
        i = i.JC(this.chatroomName).size();
        break;
      }
      i = this.iYv.size();
      break;
      label409:
      this.iYt.setChecked(false);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    return this.title;
  }
  
  public final q aRW()
  {
    AppMethodBeat.i(63539);
    if (aRY())
    {
      localObject = new d(this, this.iYo);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final o aRX()
  {
    AppMethodBeat.i(63540);
    if (aRY())
    {
      localObject = new f(this, this.iYo);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYp.contains(parama.contact.field_username);
      AppMethodBeat.o(63543);
      return bool;
    }
    AppMethodBeat.o(63543);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131492889;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63537);
    super.initView();
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63532);
        if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
        {
          h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755071, new Object[] { Integer.valueOf(1) }), "", true);
          com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = bu.m(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, s.b.JwA);
    Zv();
    this.vUs.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.g(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(v.aAC()))))
        {
          if ((AASelectContactUI.i(AASelectContactUI.this) == null) || (AASelectContactUI.i(AASelectContactUI.this).size() != AASelectContactUI.b(AASelectContactUI.this).size())) {
            break label294;
          }
          paramAnonymousMenuItem = AASelectContactUI.b(AASelectContactUI.this).iterator();
          i = 0;
          while (paramAnonymousMenuItem.hasNext())
          {
            String str = (String)paramAnonymousMenuItem.next();
            if (!AASelectContactUI.i(AASelectContactUI.this).contains(str)) {
              break;
            }
            i += 1;
          }
          if (i != AASelectContactUI.b(AASelectContactUI.this).size()) {
            break label294;
          }
        }
        label294:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            h.a(AASelectContactUI.this, AASelectContactUI.this.getString(2131755066), null, AASelectContactUI.this.getString(2131755070), AASelectContactUI.this.getString(2131755069), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63533);
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
                {
                  h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
                  com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = bu.m(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    if (x.zW(this.chatroomName))
    {
      View localView = z.jV(getContext()).inflate(2131492890, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131307262);
      ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
      localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 44);
      localLinearLayout.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 8));
      localLinearLayout.setLayoutParams(localLayoutParams);
      localView.findViewById(2131307263).setVisibility(0);
      getContentLV().addHeaderView(localView, null, false);
    }
    AppMethodBeat.o(63537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63538);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bu.isNullOrNil(paramBundle)) {
      this.iYp.addAll(bu.U(paramBundle.split(",")));
    }
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(63541);
    p localp = fMv();
    Object localObject = localp.aeW(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    ae.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    if (an.aUq((String)localObject))
    {
      AppMethodBeat.o(63541);
      return;
    }
    if (((String)localObject).equals(v.aAC()))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      fMC();
      if (!this.iYq.contains(localObject)) {
        break label235;
      }
      this.iYq.remove(localObject);
      label156:
      if (!aRY()) {
        break label247;
      }
      paramInt = this.iYo.size();
      label171:
      if (this.iYq.size() != paramInt) {
        break label286;
      }
      this.iYt.setChecked(true);
    }
    for (;;)
    {
      localp.notifyDataSetChanged();
      Zv();
      AppMethodBeat.o(63541);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label235:
      this.iYq.add(localObject);
      break label156;
      label247:
      if (!x.zW(this.chatroomName))
      {
        paramInt = i.JC(this.chatroomName).size();
        break label171;
      }
      paramInt = this.iYv.size();
      break label171;
      label286:
      this.iYt.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */