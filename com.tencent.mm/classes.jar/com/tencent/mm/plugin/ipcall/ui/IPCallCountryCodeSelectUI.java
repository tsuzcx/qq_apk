package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.b;
import com.tencent.mm.plugin.ipcall.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class IPCallCountryCodeSelectUI
  extends MMActivity
{
  private String countryCode;
  private r fzp;
  private String hLr;
  private String iJd = "";
  private List<a> list;
  public LinearLayout tNI;
  private boolean tNR = false;
  private ListView tOh;
  private f tOi;
  private IPCallCountryCodeScrollbar tOj;
  private IPCallCountryCodeScrollbar.a tOk;
  private boolean tOl = false;
  
  public void finish()
  {
    AppMethodBeat.i(25737);
    super.finish();
    overridePendingTransition(-1, 2130772106);
    AppMethodBeat.o(25737);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494503;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25739);
    setMMTitle(2131755235);
    this.fzp = new r((byte)0);
    this.fzp.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(25730);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this, paramAnonymousString);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
        AppMethodBeat.o(25730);
      }
      
      public final void aPa()
      {
        AppMethodBeat.i(25731);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this, "");
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
        AppMethodBeat.o(25731);
      }
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, this.fzp);
    this.tOj = ((IPCallCountryCodeScrollbar)findViewById(2131296489));
    long l = System.currentTimeMillis();
    Object localObject1 = c.cUg().cUj().iterator();
    int i = 0;
    int j;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      j = ((Integer)((Iterator)localObject1).next()).intValue();
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.ipcall.a.a.ajm(String.valueOf(j));
        if ((bs.isNullOrNil((String)localObject2)) || (c.cUg().Hb(j))) {
          break label809;
        }
        this.list.add(new a((String)localObject2, String.valueOf(j), 0, "0"));
        i += 1;
      }
    }
    label809:
    for (;;)
    {
      break;
      if (i > 0) {
        this.tOl = true;
      }
      Iterator localIterator;
      b localb;
      if (ab.eUK())
      {
        localIterator = com.tencent.mm.plugin.ipcall.a.a.cVP().entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.tTh;
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (!"".equals(((String)localObject2).trim())) {
              break label352;
            }
          }
          for (localObject1 = localObject2;; localObject1 = ((StringBuffer)localObject2).toString())
          {
            localObject2 = ((String)localObject1).toUpperCase();
            localObject1 = localObject2;
            if (bs.isNullOrNil((String)localObject2)) {
              localObject1 = " ";
            }
            if (c.cUg().Hb(bs.getInt(localb.tTg, 0))) {
              break;
            }
            this.list.add(new a(localb.tTh, localb.tTg, ((String)localObject1).charAt(0), (String)localObject1));
            break;
            label352:
            localObject1 = ((String)localObject2).toCharArray();
            localObject2 = new StringBuffer();
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              String str = SpellMap.v(localObject1[i]);
              if (!bs.isNullOrNil(str)) {
                ((StringBuffer)localObject2).append(str);
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuffer)localObject2).append(localObject1[i]);
              }
            }
          }
        }
      }
      else
      {
        localIterator = com.tencent.mm.plugin.ipcall.a.a.cVP().entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.tTh.toUpperCase();
          localObject1 = localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            localObject1 = " ";
          }
          if (!c.cUg().Hb(bs.getInt(localb.tTg, 0))) {
            this.list.add(new a(localb.tTh, localb.tTg, ((String)localObject1).charAt(0), (String)localObject1));
          }
        }
      }
      Collections.sort(this.list, new Comparator() {});
      localObject1 = this.list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((a)((Iterator)localObject1).next()).cVf();
        if (i != 0)
        {
          char c = (char)i;
          this.tOj.ajb(String.valueOf(c));
        }
      }
      ac.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.tNI = ((LinearLayout)findViewById(2131296496));
      this.tOh = ((ListView)findViewById(2131296471));
      this.tOi = new f(this, this.list);
      this.tOi.tNR = this.tNR;
      this.tOi.tNS = this.tOl;
      this.tOh.setAdapter(this.tOi);
      this.tOh.setVisibility(0);
      this.tOk = new IPCallCountryCodeScrollbar.a()
      {
        public final void sn(String paramAnonymousString)
        {
          int i = 0;
          AppMethodBeat.i(25732);
          int j = paramAnonymousString.charAt(0);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).setSelection(0);
            AppMethodBeat.o(25732);
            return;
          }
          paramAnonymousString = IPCallCountryCodeSelectUI.c(IPCallCountryCodeSelectUI.this).tNQ;
          if (paramAnonymousString == null)
          {
            AppMethodBeat.o(25732);
            return;
          }
          do
          {
            i += 1;
            if (i >= paramAnonymousString.length) {
              break;
            }
          } while (paramAnonymousString[i] != j);
          IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).setSelection(i + IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount());
          AppMethodBeat.o(25732);
          return;
          AppMethodBeat.o(25732);
        }
      };
      this.tOj.setOnScrollBarTouchListener(this.tOk);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25733);
          IPCallCountryCodeSelectUI.this.hideVKB();
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("country_name", IPCallCountryCodeSelectUI.d(IPCallCountryCodeSelectUI.this));
          paramAnonymousMenuItem.putExtra("couttry_code", IPCallCountryCodeSelectUI.e(IPCallCountryCodeSelectUI.this));
          IPCallCountryCodeSelectUI.this.setResult(100, paramAnonymousMenuItem);
          IPCallCountryCodeSelectUI.this.finish();
          AppMethodBeat.o(25733);
          return true;
        }
      });
      this.tOh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25734);
          paramAnonymousAdapterView = new Intent();
          if (paramAnonymousInt >= IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount())
          {
            paramAnonymousView = (a)IPCallCountryCodeSelectUI.c(IPCallCountryCodeSelectUI.this).getItem(paramAnonymousInt - IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount());
            paramAnonymousAdapterView.putExtra("country_name", paramAnonymousView.hLr);
            paramAnonymousAdapterView.putExtra("couttry_code", paramAnonymousView.countryCode);
            IPCallCountryCodeSelectUI.this.setResult(100, paramAnonymousAdapterView);
          }
          IPCallCountryCodeSelectUI.this.finish();
          AppMethodBeat.o(25734);
        }
      });
      AppMethodBeat.o(25739);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25736);
    super.onCreate(paramBundle);
    this.list = new ArrayList();
    this.hLr = bs.bG(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bs.bG(getIntent().getStringExtra("couttry_code"), "");
    this.tNR = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25729);
        IPCallCountryCodeSelectUI.this.finish();
        AppMethodBeat.o(25729);
        return false;
      }
    });
    initView();
    AppMethodBeat.o(25736);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25740);
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.hLr);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      setResult(100, paramKeyEvent);
      finish();
      AppMethodBeat.o(25740);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25740);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25738);
    super.onPause();
    if (this.fzp != null) {
      this.fzp.ftR();
    }
    AppMethodBeat.o(25738);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI
 * JD-Core Version:    0.7.0.1
 */