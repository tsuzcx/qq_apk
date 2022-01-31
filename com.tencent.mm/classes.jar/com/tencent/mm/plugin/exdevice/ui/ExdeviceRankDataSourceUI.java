package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI
  extends MMActivity
  implements f
{
  private ListView Nn;
  private b jFs;
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_rank_data_source_ui;
  }
  
  protected final void initView()
  {
    this.Nn = ((ListView)findViewById(R.h.listview));
    View localView1 = View.inflate(this, R.i.exdevice_rank_data_source_ui_header, null);
    View localView2 = View.inflate(this, R.i.exdevice_rank_data_source_ui_footer, null);
    this.Nn.addHeaderView(localView1, null, false);
    this.Nn.addFooterView(localView2, null, false);
    this.jFs = new b();
    this.Nn.setAdapter(this.jFs);
    ((ScrollView)findViewById(R.h.scrollview)).scrollTo(0, 0);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(ExdeviceRankDataSourceUI.this.mController.uMN, ExdeviceAddDataSourceUI.class);
        ExdeviceRankDataSourceUI.this.startActivityForResult(paramAnonymousView, 1);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    long l;
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null))
    {
      l = paramIntent.getLongExtra("device_mac", 0L);
      paramIntent.getIntExtra("step", 0);
      if (l == 0L) {
        y.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
      }
    }
    else
    {
      return;
    }
    paramIntent = com.tencent.mm.plugin.exdevice.j.b.ee(l);
    if (paramIntent == null)
    {
      y.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", new Object[] { paramIntent });
      return;
    }
    if (this.jFs.BR(paramIntent) != null)
    {
      y.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
      return;
    }
    paramIntent = ad.aLL().ed(l);
    if (paramIntent == null)
    {
      y.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", new Object[] { Long.valueOf(l) });
      return;
    }
    if (this.jFs.cU(paramIntent.field_deviceID, paramIntent.field_deviceType) != null)
    {
      y.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
      return;
    }
    au.Dk().a(1267, this);
    au.Dk().a(new q(), 0);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceRankDataSourceUI.1(this));
    setMMTitle(R.l.contact_info_record_data);
    au.Dk().a(1267, this);
    initView();
    au.Dk().a(new q(), 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(1267, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm == null) {
      y.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
    }
    do
    {
      do
      {
        return;
      } while (!(paramm instanceof q));
      au.Dk().b(1267, this);
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = (akp)((q)paramm).dmK.ecF.ecN;
    if (paramString.tbC != null) {}
    for (paramInt1 = paramString.tbC.size();; paramInt1 = 0)
    {
      y.d("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, get sport device list succ.(size : %d)", new Object[] { Integer.valueOf(paramInt1) });
      runOnUiThread(new ExdeviceRankDataSourceUI.3(this, paramString.tbC));
      return;
    }
  }
  
  private static final class b
    extends BaseAdapter
  {
    private com.tencent.mm.as.a.a.c jAJ;
    List<ExdeviceRankDataSourceUI.a> jFx = new LinkedList();
    
    public b()
    {
      c.a locala = new c.a();
      locala.eru = R.g.exdevice_wechat_sport_default_icon;
      this.jAJ = locala.OV();
    }
    
    private ExdeviceRankDataSourceUI.a qA(int paramInt)
    {
      return (ExdeviceRankDataSourceUI.a)this.jFx.get(paramInt);
    }
    
    /* Error */
    public final ExdeviceRankDataSourceUI.a BR(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic 61	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   6: ifne +54 -> 60
      //   9: aload_0
      //   10: getfield 24	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:jFx	Ljava/util/List;
      //   13: invokeinterface 65 1 0
      //   18: astore 4
      //   20: aload 4
      //   22: invokeinterface 71 1 0
      //   27: ifeq +33 -> 60
      //   30: aload 4
      //   32: invokeinterface 75 1 0
      //   37: checkcast 53	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
      //   40: astore_3
      //   41: aload_1
      //   42: aload_3
      //   43: getfield 79	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:mac	Ljava/lang/String;
      //   46: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   49: istore_2
      //   50: iload_2
      //   51: ifeq -31 -> 20
      //   54: aload_3
      //   55: astore_1
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_1
      //   59: areturn
      //   60: aconst_null
      //   61: astore_1
      //   62: goto -6 -> 56
      //   65: astore_1
      //   66: aload_0
      //   67: monitorexit
      //   68: aload_1
      //   69: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	b
      //   0	70	1	paramString	String
      //   49	2	2	bool	boolean
      //   40	15	3	locala	ExdeviceRankDataSourceUI.a
      //   18	13	4	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   2	20	65	finally
      //   20	50	65	finally
    }
    
    /* Error */
    public final ExdeviceRankDataSourceUI.a cU(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:jFx	Ljava/util/List;
      //   6: invokeinterface 65 1 0
      //   11: astore 5
      //   13: aload 5
      //   15: invokeinterface 71 1 0
      //   20: ifeq +42 -> 62
      //   23: aload 5
      //   25: invokeinterface 75 1 0
      //   30: checkcast 53	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
      //   33: astore 4
      //   35: aload 4
      //   37: ifnull -24 -> 13
      //   40: aload_1
      //   41: aload_2
      //   42: aload 4
      //   44: getfield 91	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:jFv	Lcom/tencent/mm/protocal/c/cch;
      //   47: invokestatic 94	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/c/cch;)Z
      //   50: istore_3
      //   51: iload_3
      //   52: ifeq -39 -> 13
      //   55: aload 4
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: areturn
      //   62: aconst_null
      //   63: astore_1
      //   64: goto -6 -> 58
      //   67: astore_1
      //   68: aload_0
      //   69: monitorexit
      //   70: aload_1
      //   71: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	this	b
      //   0	72	1	paramString1	String
      //   0	72	2	paramString2	String
      //   50	2	3	bool	boolean
      //   33	23	4	locala	ExdeviceRankDataSourceUI.a
      //   11	13	5	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   2	13	67	finally
      //   13	35	67	finally
      //   40	51	67	finally
    }
    
    public final int getCount()
    {
      return this.jFx.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ExdeviceRankDataSourceUI.a locala = qA(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), R.i.exdevice_rank_data_source_item, null);
        paramView.fhD = ((TextView)((View)localObject).findViewById(R.h.nameTV));
        paramView.gSx = ((ImageView)((View)localObject).findViewById(R.h.iconIV));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      for (;;)
      {
        localObject = ExdeviceRankDataSourceUI.a(locala);
        y.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localObject, locala.mac });
        paramViewGroup.fhD.setText((CharSequence)localObject);
        o.ON().a(locala.jFv.kSy, paramViewGroup.gSx, this.jAJ);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private static final class a
    {
      TextView fhD;
      ImageView gSx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI
 * JD-Core Version:    0.7.0.1
 */