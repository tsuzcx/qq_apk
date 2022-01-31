package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import java.util.ArrayList;
import java.util.Collections;
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
  private n drn;
  private String esg;
  private String feq = "";
  private List<a> list;
  public LinearLayout luO;
  private boolean luZ = false;
  private ListView lvp;
  private f lvq;
  private IPCallCountryCodeScrollbar lvr;
  private IPCallCountryCodeScrollbar.a lvs;
  private boolean lvt = false;
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(-1, R.a.push_down_out);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_country_select_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.address_title_select_country_code);
    this.drn = new n((byte)0);
    this.drn.weq = new IPCallCountryCodeSelectUI.2(this);
    a(this.drn);
    this.lvr = ((IPCallCountryCodeScrollbar)findViewById(R.h.address_scrollbar));
    long l = System.currentTimeMillis();
    Object localObject1 = c.bbS().bbV().iterator();
    int i = 0;
    int j;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      j = ((Integer)((Iterator)localObject1).next()).intValue();
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.ipcall.b.a.FY(String.valueOf(j));
        if ((bk.bl((String)localObject2)) || (c.bbS().sE(j))) {
          break label798;
        }
        this.list.add(new a((String)localObject2, String.valueOf(j), 0, "0"));
        i += 1;
      }
    }
    label798:
    for (;;)
    {
      break;
      if (i > 0) {
        this.lvt = true;
      }
      Iterator localIterator;
      b localb;
      if (x.cqF())
      {
        localIterator = com.tencent.mm.plugin.ipcall.b.a.bdn().entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.lAt;
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (!"".equals(((String)localObject2).trim())) {
              break label347;
            }
          }
          for (localObject1 = localObject2;; localObject1 = ((StringBuffer)localObject2).toString())
          {
            localObject2 = ((String)localObject1).toUpperCase();
            localObject1 = localObject2;
            if (bk.bl((String)localObject2)) {
              localObject1 = " ";
            }
            if (c.bbS().sE(bk.getInt(localb.lAs, 0))) {
              break;
            }
            this.list.add(new a(localb.lAt, localb.lAs, ((String)localObject1).charAt(0), (String)localObject1));
            break;
            label347:
            localObject1 = ((String)localObject2).toCharArray();
            localObject2 = new StringBuffer();
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              String str = SpellMap.e(localObject1[i]);
              if (!bk.bl(str)) {
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
        localIterator = com.tencent.mm.plugin.ipcall.b.a.bdn().entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.lAt.toUpperCase();
          localObject1 = localObject2;
          if (bk.bl((String)localObject2)) {
            localObject1 = " ";
          }
          if (!c.bbS().sE(bk.getInt(localb.lAs, 0))) {
            this.list.add(new a(localb.lAt, localb.lAs, ((String)localObject1).charAt(0), (String)localObject1));
          }
        }
      }
      Collections.sort(this.list, new IPCallCountryCodeSelectUI.6(this));
      localObject1 = this.list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((a)((Iterator)localObject1).next()).bcP();
        if (i != 0)
        {
          char c = (char)i;
          this.lvr.FN(String.valueOf(c));
        }
      }
      y.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.luO = ((LinearLayout)findViewById(R.h.address_ui_hint_ll));
      this.lvp = ((ListView)findViewById(R.h.address_contactlist));
      this.lvq = new f(this, this.list);
      this.lvq.luZ = this.luZ;
      this.lvq.lva = this.lvt;
      this.lvp.setAdapter(this.lvq);
      this.lvp.setVisibility(0);
      this.lvs = new IPCallCountryCodeScrollbar.a()
      {
        public final void eU(String paramAnonymousString)
        {
          int i = 0;
          int j = paramAnonymousString.charAt(0);
          if ("↑".equals(paramAnonymousString)) {
            IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).setSelection(0);
          }
          for (;;)
          {
            return;
            paramAnonymousString = IPCallCountryCodeSelectUI.c(IPCallCountryCodeSelectUI.this).luY;
            if (paramAnonymousString != null) {
              while (i < paramAnonymousString.length)
              {
                if (paramAnonymousString[i] == j)
                {
                  IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).setSelection(i + IPCallCountryCodeSelectUI.b(IPCallCountryCodeSelectUI.this).getHeaderViewsCount());
                  return;
                }
                i += 1;
              }
            }
          }
        }
      };
      this.lvr.setOnScrollBarTouchListener(this.lvs);
      setBackBtn(new IPCallCountryCodeSelectUI.4(this));
      this.lvp.setOnItemClickListener(new IPCallCountryCodeSelectUI.5(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.list = new ArrayList();
    this.esg = bk.aM(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bk.aM(getIntent().getStringExtra("couttry_code"), "");
    this.luZ = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        IPCallCountryCodeSelectUI.this.finish();
        return false;
      }
    });
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.esg);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      setResult(100, paramKeyEvent);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.drn != null) {
      this.drn.cJg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI
 * JD-Core Version:    0.7.0.1
 */