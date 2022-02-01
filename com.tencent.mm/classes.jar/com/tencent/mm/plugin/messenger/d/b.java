package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.a.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class b
{
  public WeakReference<b> tzf = null;
  
  public b(b paramb)
  {
    Assert.assertNotNull(paramb);
    this.tzf = new WeakReference(paramb);
    ((f)g.ab(f.class)).a(cPc(), new f.b()
    {
      public final CharSequence a(Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(196726);
        String str = paramAnonymousBundle.getString("conv_talker_username", "");
        if (paramAnonymousMap == null)
        {
          ad.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non map!!");
          AppMethodBeat.o(196726);
          return null;
        }
        if (bt.isNullOrNil(paramAnonymousString))
        {
          ad.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non header!!");
          AppMethodBeat.o(196726);
          return null;
        }
        if (bt.isNullOrNil(str))
        {
          ad.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: not resolved talker!!");
          AppMethodBeat.o(196726);
          return null;
        }
        paramAnonymousMap = b.this.b(paramAnonymousMap, paramAnonymousString, paramAnonymousBundle, paramAnonymousWeakReference, paramAnonymousWeakReference1);
        AppMethodBeat.o(196726);
        return paramAnonymousMap;
      }
    });
  }
  
  protected abstract CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  protected abstract String cPc();
  
  public void release()
  {
    ((f)g.ab(f.class)).afO(cPc());
  }
  
  public final class a
  {
    public String link;
    public String username;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, b.a parama);
    
    public abstract void az(LinkedList<String> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.b
 * JD-Core Version:    0.7.0.1
 */