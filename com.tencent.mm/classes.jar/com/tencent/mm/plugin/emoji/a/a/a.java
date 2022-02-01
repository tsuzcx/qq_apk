package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String jvw = "lock";
  private Context mContext;
  public AbsListView uAN;
  public c uAO;
  public o.a uAP;
  protected volatile boolean uAQ = false;
  private int uAR = 0;
  private int uAS = 0;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> uAy;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.uAy = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.uAZ == f.a.uBi) {
      return paramf.uBb.ffF + "_cell";
    }
    return paramf.uBa.ProductID;
  }
  
  public abstract void Js(int paramInt);
  
  public abstract void Jt(int paramInt);
  
  public abstract void Ju(int paramInt);
  
  public f Jv(int paramInt)
  {
    if (this.uAO == null) {
      return null;
    }
    return this.uAO.JA(paramInt);
  }
  
  protected c a(l paraml)
  {
    return new c(paraml);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.uAO == paramc)) {
      return;
    }
    this.uAO = paramc.cTR();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.uAO.dy(paramString, paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a atU(String paramString)
  {
    if (this.uAy == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.uAy.get(paramString);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final l paraml)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108349);
        if (paraml == null)
        {
          AppMethodBeat.o(108349);
          return;
        }
        a.a(a.this, a.this.a(paraml));
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(108349);
      }
    });
  }
  
  protected void cTL()
  {
    if (this.uAy != null) {
      this.uAy.clear();
    }
    super.notifyDataSetChanged();
    this.uAQ = true;
  }
  
  public abstract int cTM();
  
  public abstract int cTN();
  
  public abstract int cTO();
  
  public void clear()
  {
    if (this.uAy != null)
    {
      this.uAy.clear();
      this.uAy = null;
    }
    if (this.uAO != null)
    {
      this.uAO.clear();
      this.uAO = null;
    }
    this.uAQ = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public void dw(String paramString, int paramInt)
  {
    if ((this.uAy == null) || (this.uAO == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.uAO.atV(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.uAO != null) && (((f)localObject).mStatus == -1))
      {
        Log.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.uAO.uAX, this.uAO.atZ(paramString), this.uAO.atX(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = atU(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cTJ();
          return;
        }
      }
    }
  }
  
  public final void dx(String paramString, int paramInt)
  {
    if ((this.uAy == null) || (this.uAO == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.uAO.atV(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).IB = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = atU(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cTJ();
          return;
        }
      }
    }
  }
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    if (this.uAO == null) {
      return 0;
    }
    return this.uAO.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.emoji.a.a locala1 = null;
    if (paramView != null) {
      locala1 = (com.tencent.mm.plugin.emoji.a.a)paramView.getTag();
    }
    f localf = Jv(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.uAy.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.uzy = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.cTJ();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!Util.isNullOrNil(a(localf)))
      {
        if (this.uAy.containsValue(locala1)) {
          this.uAy.remove(locala1.getProductId());
        }
        this.uAy.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.uAQ = false;
    if (this.uAO != null)
    {
      this.uAO.notifyDataSetChanged();
      i = this.uAR;
      this.uAR = (i + 1);
      Log.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.uAS;
    this.uAS = (i + 1);
    Log.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    cTL();
  }
  
  public final void refreshView()
  {
    if (!this.uAQ) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */