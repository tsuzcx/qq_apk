package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int bTs = 0;
  private f dnn;
  private RcptItem fvv = null;
  private RcptItem fvw = null;
  private List<RcptItem> fvx;
  
  private void YR()
  {
    switch (this.bTs)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.bTs);
      localIntent.putExtra("key_province", this.fvv);
      localIntent.putExtra("key_city", this.fvw);
      setResult(0, localIntent);
      finish();
      return;
      this.fvw = null;
      this.bTs = 1;
      continue;
      this.fvv = null;
      this.bTs = 0;
    }
  }
  
  private void k(Intent paramIntent)
  {
    Object localObject2 = null;
    if (paramIntent == null) {
      y.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
    }
    Object localObject1;
    label124:
    do
    {
      return;
      this.bTs = paramIntent.getIntExtra("key_stage", 0);
      this.fvv = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
      this.fvw = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
      localObject3 = paramIntent.getStringExtra("extra_province");
      if (localObject3 != null)
      {
        a.YB();
        localObject1 = a.YD();
        if (bk.bl((String)localObject3)) {
          break;
        }
        Iterator localIterator = ((l)localObject1).ftt.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (RcptItem)localIterator.next();
        } while (!((RcptItem)localObject1).name.startsWith((String)localObject3));
        this.fvv = ((RcptItem)localObject1);
        if (this.fvv != null) {
          this.bTs = 1;
        }
      }
      localObject1 = paramIntent.getStringExtra("extra_city");
    } while ((localObject1 == null) || (1 != this.bTs));
    a.YB();
    Object localObject3 = a.YD().ql(this.fvv.code);
    paramIntent = localObject2;
    if (localObject3 != null)
    {
      if (((List)localObject3).size() != 0) {
        break label221;
      }
      paramIntent = localObject2;
    }
    for (;;)
    {
      this.fvw = paramIntent;
      if (this.fvw == null) {
        break;
      }
      this.bTs = 2;
      return;
      localObject1 = null;
      break label124;
      label221:
      localObject3 = ((List)localObject3).iterator();
      do
      {
        paramIntent = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramIntent = (RcptItem)((Iterator)localObject3).next();
      } while (!paramIntent.name.startsWith((String)localObject1));
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if ((paramPreference instanceof RcptPreference))
    {
      paramf = ((RcptPreference)paramPreference).fvm;
      if ((paramf == null) || (bk.bl(paramf.name))) {
        y.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
      }
    }
    else
    {
      return false;
    }
    if (!paramf.ftr) {
      this.bTs = 2;
    }
    switch (this.bTs)
    {
    default: 
      paramf = getIntent();
      if (paramf == null) {
        break;
      }
    }
    for (int i = paramf.getIntExtra("ui_title", -1);; i = -1)
    {
      paramf = new Intent(this, WalletMultiRcptSelectUI.class);
      paramf.putExtra("key_stage", this.bTs);
      paramf.putExtra("key_province", this.fvv);
      paramf.putExtra("key_city", this.fvw);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      return false;
      this.fvv = paramf;
      this.bTs = 1;
      break;
      this.fvw = paramf;
      this.bTs = 2;
      break;
      paramPreference = new StringBuilder();
      if (this.fvv != null) {
        paramPreference.append(this.fvv.name).append(" ");
      }
      if (this.fvw != null) {
        paramPreference.append(this.fvw.name).append(" ");
      }
      paramPreference.append(paramf.name);
      y.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
      Intent localIntent = new Intent();
      localIntent.putExtra("karea_result", paramPreference.toString());
      localIntent.putExtra("kpost_code", paramf.ftq);
      localIntent.putExtra("kwcode", paramf.code);
      setResult(-1, localIntent);
      finish();
      return false;
    }
  }
  
  protected final void initView()
  {
    Object localObject = getIntent();
    int i = R.l.address_select_title;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", R.l.address_select_title);
    }
    setMMTitle(i);
    setBackBtn(new WalletMultiRcptSelectUI.1(this));
    k((Intent)localObject);
    localObject = a.YD().ftt;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      y.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.YD().YE();
    }
    switch (this.bTs)
    {
    default: 
      a.YB();
      localObject = a.YD().ftt;
    }
    for (;;)
    {
      this.fvx = ((List)localObject);
      if ((this.fvx != null) && (this.fvx.size() > 0)) {
        break label247;
      }
      y.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      return;
      a.YB();
      localObject = a.YD().ftt;
      continue;
      if ((this.fvv != null) && (!bk.bl(this.fvv.code)))
      {
        a.YB();
        localObject = a.YD().ql(this.fvv.code);
      }
      else
      {
        if ((this.fvw == null) || (bk.bl(this.fvw.code))) {
          break;
        }
        a.YB();
        localObject = a.YD().qm(this.fvw.code);
      }
    }
    label247:
    this.dnn.removeAll();
    i = 0;
    if (i < this.fvx.size())
    {
      RcptItem localRcptItem;
      if ((this.fvx.get(i) != null) && (!bk.bl(((RcptItem)this.fvx.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.fvx.get(i);
        if ((localRcptItem != null) && (!bk.bl(localRcptItem.name))) {
          break label367;
        }
        y.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.dnn.a((Preference)localObject);
        i += 1;
        break;
        label367:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).fvm = localRcptItem;
      }
    }
    localObject = new PreferenceSmallCategory(this);
    this.dnn.a((Preference)localObject);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
      return;
    }
    k(paramIntent);
  }
  
  public void onBackPressed()
  {
    YR();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public final int xj()
  {
    return R.o.rptselect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */