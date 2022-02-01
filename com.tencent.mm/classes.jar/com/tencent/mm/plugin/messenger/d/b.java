package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class b
{
  public WeakReference<b> vWJ = null;
  
  public b(b paramb)
  {
    Assert.assertNotNull(paramb);
    this.vWJ = new WeakReference(paramb);
    ((e)g.ab(e.class)).a(dpe(), new e.b()
    {
      public final CharSequence a(Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(218169);
        String str = paramAnonymousBundle.getString("conv_talker_username", "");
        if (paramAnonymousMap == null)
        {
          ae.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non map!!");
          AppMethodBeat.o(218169);
          return null;
        }
        if (bu.isNullOrNil(paramAnonymousString))
        {
          ae.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non header!!");
          AppMethodBeat.o(218169);
          return null;
        }
        if (bu.isNullOrNil(str))
        {
          ae.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: not resolved talker!!");
          AppMethodBeat.o(218169);
          return null;
        }
        paramAnonymousMap = b.this.b(paramAnonymousMap, paramAnonymousString, paramAnonymousBundle, paramAnonymousWeakReference, paramAnonymousWeakReference1);
        AppMethodBeat.o(218169);
        return paramAnonymousMap;
      }
    });
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    if ((this.vWJ != null) && (this.vWJ.get() != null)) {
      ((b)this.vWJ.get()).a(paramLong, paramLinkedList, paramInt);
    }
  }
  
  protected abstract CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  protected abstract String dpe();
  
  public void release()
  {
    ((e)g.ab(e.class)).aqz(dpe());
  }
  
  public final class a
  {
    public String link;
    public String username;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt);
    
    public abstract void a(View paramView, b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.b
 * JD-Core Version:    0.7.0.1
 */