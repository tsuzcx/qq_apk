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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private r fvI;
  private String hkO;
  private String iiW = "";
  private List<a> list;
  private ListView sGA;
  private f sGB;
  private IPCallCountryCodeScrollbar sGC;
  private IPCallCountryCodeScrollbar.a sGD;
  private boolean sGE = false;
  public LinearLayout sGb;
  private boolean sGk = false;
  
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
    this.fvI = new r((byte)0);
    this.fvI.Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(25730);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this, paramAnonymousString);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
        AppMethodBeat.o(25730);
      }
      
      public final void aIj()
      {
        AppMethodBeat.i(25731);
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this, "");
        IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
        AppMethodBeat.o(25731);
      }
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm() {}
    };
    addSearchMenu(true, this.fvI);
    this.sGC = ((IPCallCountryCodeScrollbar)findViewById(2131296489));
    long l = System.currentTimeMillis();
    Object localObject1 = c.cGV().cGY().iterator();
    int i = 0;
    int j;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      j = ((Integer)((Iterator)localObject1).next()).intValue();
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.ipcall.a.a.aeu(String.valueOf(j));
        if ((bt.isNullOrNil((String)localObject2)) || (c.cGV().Fg(j))) {
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
        this.sGE = true;
      }
      Iterator localIterator;
      b localb;
      if (ac.eFq())
      {
        localIterator = com.tencent.mm.plugin.ipcall.a.a.cIE().entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.sLC;
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
            if (bt.isNullOrNil((String)localObject2)) {
              localObject1 = " ";
            }
            if (c.cGV().Fg(bt.getInt(localb.sLB, 0))) {
              break;
            }
            this.list.add(new a(localb.sLC, localb.sLB, ((String)localObject1).charAt(0), (String)localObject1));
            break;
            label352:
            localObject1 = ((String)localObject2).toCharArray();
            localObject2 = new StringBuffer();
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              String str = SpellMap.v(localObject1[i]);
              if (!bt.isNullOrNil(str)) {
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
        localIterator = com.tencent.mm.plugin.ipcall.a.a.cIE().entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.sLC.toUpperCase();
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = " ";
          }
          if (!c.cGV().Fg(bt.getInt(localb.sLB, 0))) {
            this.list.add(new a(localb.sLC, localb.sLB, ((String)localObject1).charAt(0), (String)localObject1));
          }
        }
      }
      Collections.sort(this.list, new Comparator() {});
      localObject1 = this.list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((a)((Iterator)localObject1).next()).cHU();
        if (i != 0)
        {
          char c = (char)i;
          this.sGC.aej(String.valueOf(c));
        }
      }
      ad.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.sGb = ((LinearLayout)findViewById(2131296496));
      this.sGA = ((ListView)findViewById(2131296471));
      this.sGB = new f(this, this.list);
      this.sGB.sGk = this.sGk;
      this.sGB.sGl = this.sGE;
      this.sGA.setAdapter(this.sGB);
      this.sGA.setVisibility(0);
      this.sGD = new IPCallCountryCodeScrollbar.a()
      {
        public final void pb(String paramAnonymousString)
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
          paramAnonymousString = IPCallCountryCodeSelectUI.c(IPCallCountryCodeSelectUI.this).sGj;
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
      this.sGC.setOnScrollBarTouchListener(this.sGD);
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
      this.sGA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25734);
          paramAnonymousAdapterView = new Intent();
          if (paramAnonymousInt >= IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount())
          {
            paramAnonymousView = (a)IPCallCountryCodeSelectUI.c(IPCallCountryCodeSelectUI.this).getItem(paramAnonymousInt - IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount());
            paramAnonymousAdapterView.putExtra("country_name", paramAnonymousView.hkO);
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
    this.hkO = bt.by(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bt.by(getIntent().getStringExtra("couttry_code"), "");
    this.sGk = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
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
      paramKeyEvent.putExtra("country_name", this.hkO);
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
    if (this.fvI != null) {
      this.fvI.fdW();
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