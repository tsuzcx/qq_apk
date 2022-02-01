package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.epa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI
  extends MMActivity
  implements i
{
  private ListView mListView;
  private b rKh;
  
  public int getLayoutId()
  {
    return 2131494039;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24197);
    this.mListView = ((ListView)findViewById(2131303242));
    View localView1 = View.inflate(this, 2131494041, null);
    View localView2 = View.inflate(this, 2131494040, null);
    this.mListView.addHeaderView(localView1, null, false);
    this.mListView.addFooterView(localView2, null, false);
    this.rKh = new b();
    this.mListView.setAdapter(this.rKh);
    ((ScrollView)findViewById(2131307342)).scrollTo(0, 0);
    localView2.setOnClickListener(new ExdeviceRankDataSourceUI.2(this));
    AppMethodBeat.o(24197);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24200);
    Log.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("device_mac", 0L);
      paramIntent.getIntExtra("step", 0);
      if (l == 0L)
      {
        Log.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
        AppMethodBeat.o(24200);
        return;
      }
      paramIntent = com.tencent.mm.plugin.exdevice.k.b.Dj(l);
      if (paramIntent == null)
      {
        Log.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", new Object[] { paramIntent });
        AppMethodBeat.o(24200);
        return;
      }
      if (this.rKh.anU(paramIntent) != null)
      {
        Log.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
        AppMethodBeat.o(24200);
        return;
      }
      paramIntent = ad.cKL().Di(l);
      if (paramIntent == null)
      {
        Log.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(24200);
        return;
      }
      if (this.rKh.gf(paramIntent.field_deviceID, paramIntent.field_deviceType) != null)
      {
        Log.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
        AppMethodBeat.o(24200);
        return;
      }
      bg.azz().a(1267, this);
      bg.azz().a(new com.tencent.mm.plugin.exdevice.model.q(), 0);
    }
    AppMethodBeat.o(24200);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(24198);
    finish();
    AppMethodBeat.o(24198);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24196);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceRankDataSourceUI.1(this));
    setMMTitle(2131758028);
    bg.azz().a(1267, this);
    initView();
    bg.azz().a(new com.tencent.mm.plugin.exdevice.model.q(), 0);
    AppMethodBeat.o(24196);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24199);
    super.onDestroy();
    bg.azz().b(1267, this);
    AppMethodBeat.o(24199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(24201);
    if (paramq == null)
    {
      Log.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(24201);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.exdevice.model.q))
    {
      bg.azz().b(1267, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bvo)((com.tencent.mm.plugin.exdevice.model.q)paramq).rr.iLL.iLR;
        if (paramString.LTo == null) {
          break label127;
        }
      }
    }
    label127:
    for (paramInt1 = paramString.LTo.size();; paramInt1 = 0)
    {
      Log.d("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, get sport device list succ.(size : %d)", new Object[] { Integer.valueOf(paramInt1) });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24188);
          ExdeviceRankDataSourceUI.b localb = ExdeviceRankDataSourceUI.b(ExdeviceRankDataSourceUI.this);
          Object localObject = this.rKj;
          localb.rKm.clear();
          if ((localObject == null) || (((List)localObject).size() == 0)) {}
          for (;;)
          {
            ExdeviceRankDataSourceUI.b(ExdeviceRankDataSourceUI.this).notifyDataSetChanged();
            AppMethodBeat.o(24188);
            return;
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              epa localepa = (epa)((Iterator)localObject).next();
              if (localepa != null) {
                localb.rKm.add(ExdeviceRankDataSourceUI.a(localepa));
              }
            }
          }
        }
      });
      AppMethodBeat.o(24201);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    String mac;
    epa rKk;
    com.tencent.mm.plugin.exdevice.i.b rKl;
  }
  
  static final class b
    extends BaseAdapter
  {
    private com.tencent.mm.av.a.a.c rFu;
    List<ExdeviceRankDataSourceUI.a> rKm;
    
    public b()
    {
      AppMethodBeat.i(24189);
      this.rKm = new LinkedList();
      c.a locala = new c.a();
      locala.jbq = 2131232219;
      this.rFu = locala.bdv();
      AppMethodBeat.o(24189);
    }
    
    private ExdeviceRankDataSourceUI.a GJ(int paramInt)
    {
      AppMethodBeat.i(24193);
      ExdeviceRankDataSourceUI.a locala = (ExdeviceRankDataSourceUI.a)this.rKm.get(paramInt);
      AppMethodBeat.o(24193);
      return locala;
    }
    
    /* Error */
    public final ExdeviceRankDataSourceUI.a anU(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: sipush 24190
      //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_1
      //   9: invokestatic 66	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifne +55 -> 67
      //   15: aload_0
      //   16: getfield 30	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:rKm	Ljava/util/List;
      //   19: invokeinterface 70 1 0
      //   24: astore_3
      //   25: aload_3
      //   26: invokeinterface 76 1 0
      //   31: ifeq +36 -> 67
      //   34: aload_3
      //   35: invokeinterface 80 1 0
      //   40: checkcast 58	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
      //   43: astore_2
      //   44: aload_1
      //   45: aload_2
      //   46: getfield 84	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:mac	Ljava/lang/String;
      //   49: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   52: ifeq -27 -> 25
      //   55: sipush 24190
      //   58: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   61: aload_2
      //   62: astore_1
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_1
      //   66: areturn
      //   67: aconst_null
      //   68: astore_1
      //   69: sipush 24190
      //   72: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: goto -12 -> 63
      //   78: astore_1
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	b
      //   0	83	1	paramString	String
      //   43	19	2	locala	ExdeviceRankDataSourceUI.a
      //   24	11	3	localIterator	Iterator
      // Exception table:
      //   from	to	target	type
      //   2	25	78	finally
      //   25	61	78	finally
      //   69	75	78	finally
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24192);
      int i = this.rKm.size();
      AppMethodBeat.o(24192);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(24194);
      ExdeviceRankDataSourceUI.a locala = GJ(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131494038, null);
        paramView.kgE = ((TextView)((View)localObject).findViewById(2131305210));
        paramView.nnL = ((ImageView)((View)localObject).findViewById(2131302475));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      for (;;)
      {
        localObject = ExdeviceRankDataSourceUI.a(locala);
        Log.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localObject, locala.mac });
        paramViewGroup.kgE.setText((CharSequence)localObject);
        com.tencent.mm.av.q.bcV().a(locala.rKk.IconUrl, paramViewGroup.nnL, this.rFu);
        AppMethodBeat.o(24194);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    /* Error */
    public final ExdeviceRankDataSourceUI.a gf(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: sipush 24191
      //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 30	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:rKm	Ljava/util/List;
      //   12: invokeinterface 70 1 0
      //   17: astore 4
      //   19: aload 4
      //   21: invokeinterface 76 1 0
      //   26: ifeq +42 -> 68
      //   29: aload 4
      //   31: invokeinterface 80 1 0
      //   36: checkcast 58	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
      //   39: astore_3
      //   40: aload_3
      //   41: ifnull -22 -> 19
      //   44: aload_1
      //   45: aload_2
      //   46: aload_3
      //   47: getfield 175	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:rKk	Lcom/tencent/mm/protocal/protobuf/epa;
      //   50: invokestatic 193	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/epa;)Z
      //   53: ifeq -34 -> 19
      //   56: sipush 24191
      //   59: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: aload_3
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: areturn
      //   68: aconst_null
      //   69: astore_1
      //   70: sipush 24191
      //   73: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   76: goto -12 -> 64
      //   79: astore_1
      //   80: aload_0
      //   81: monitorexit
      //   82: aload_1
      //   83: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	b
      //   0	84	1	paramString1	String
      //   0	84	2	paramString2	String
      //   39	24	3	locala	ExdeviceRankDataSourceUI.a
      //   17	13	4	localIterator	Iterator
      // Exception table:
      //   from	to	target	type
      //   2	19	79	finally
      //   19	40	79	finally
      //   44	62	79	finally
      //   70	76	79	finally
    }
    
    static final class a
    {
      TextView kgE;
      ImageView nnL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI
 * JD-Core Version:    0.7.0.1
 */