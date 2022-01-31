package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
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
  private q eiV;
  private String fHT;
  private String gvZ = "";
  private List<a> list;
  private ListView nSF;
  private f nSG;
  private IPCallCountryCodeScrollbar nSH;
  private IPCallCountryCodeScrollbar.a nSI;
  private boolean nSJ = false;
  public LinearLayout nSg;
  private boolean nSq = false;
  
  public void finish()
  {
    AppMethodBeat.i(22119);
    super.finish();
    overridePendingTransition(-1, 2131034228);
    AppMethodBeat.o(22119);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969925;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22121);
    setMMTitle(2131296503);
    this.eiV = new q((byte)0);
    this.eiV.Axg = new IPCallCountryCodeSelectUI.2(this);
    addSearchMenu(true, this.eiV);
    this.nSH = ((IPCallCountryCodeScrollbar)findViewById(2131821077));
    long l = System.currentTimeMillis();
    Object localObject1 = c.bIZ().bJc().iterator();
    int i = 0;
    int j;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      j = ((Integer)((Iterator)localObject1).next()).intValue();
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.ipcall.b.a.RA(String.valueOf(j));
        if ((bo.isNullOrNil((String)localObject2)) || (c.bIZ().xE(j))) {
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
        this.nSJ = true;
      }
      Iterator localIterator;
      b localb;
      if (aa.dsC())
      {
        localIterator = com.tencent.mm.plugin.ipcall.b.a.bKH().entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.nXF;
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
            if (bo.isNullOrNil((String)localObject2)) {
              localObject1 = " ";
            }
            if (c.bIZ().xE(bo.getInt(localb.nXE, 0))) {
              break;
            }
            this.list.add(new a(localb.nXF, localb.nXE, ((String)localObject1).charAt(0), (String)localObject1));
            break;
            label352:
            localObject1 = ((String)localObject2).toCharArray();
            localObject2 = new StringBuffer();
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              String str = SpellMap.u(localObject1[i]);
              if (!bo.isNullOrNil(str)) {
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
        localIterator = com.tencent.mm.plugin.ipcall.b.a.bKH().entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ((Map.Entry)localObject1).getKey();
          localb = (b)((Map.Entry)localObject1).getValue();
          localObject2 = localb.nXF.toUpperCase();
          localObject1 = localObject2;
          if (bo.isNullOrNil((String)localObject2)) {
            localObject1 = " ";
          }
          if (!c.bIZ().xE(bo.getInt(localb.nXE, 0))) {
            this.list.add(new a(localb.nXF, localb.nXE, ((String)localObject1).charAt(0), (String)localObject1));
          }
        }
      }
      Collections.sort(this.list, new IPCallCountryCodeSelectUI.6(this));
      localObject1 = this.list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((a)((Iterator)localObject1).next()).bJY();
        if (i != 0)
        {
          char c = (char)i;
          this.nSH.Rp(String.valueOf(c));
        }
      }
      ab.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.nSg = ((LinearLayout)findViewById(2131825169));
      this.nSF = ((ListView)findViewById(2131821074));
      this.nSG = new f(this, this.list);
      this.nSG.nSq = this.nSq;
      this.nSG.nSr = this.nSJ;
      this.nSF.setAdapter(this.nSG);
      this.nSF.setVisibility(0);
      this.nSI = new IPCallCountryCodeSelectUI.3(this);
      this.nSH.setOnScrollBarTouchListener(this.nSI);
      setBackBtn(new IPCallCountryCodeSelectUI.4(this));
      this.nSF.setOnItemClickListener(new IPCallCountryCodeSelectUI.5(this));
      AppMethodBeat.o(22121);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22118);
    super.onCreate(paramBundle);
    this.list = new ArrayList();
    this.fHT = bo.bf(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bo.bf(getIntent().getStringExtra("couttry_code"), "");
    this.nSq = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
    setBackBtn(new IPCallCountryCodeSelectUI.1(this));
    initView();
    AppMethodBeat.o(22118);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22122);
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.fHT);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      setResult(100, paramKeyEvent);
      finish();
      AppMethodBeat.o(22122);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22122);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22120);
    super.onPause();
    if (this.eiV != null) {
      this.eiV.dNV();
    }
    AppMethodBeat.o(22120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI
 * JD-Core Version:    0.7.0.1
 */