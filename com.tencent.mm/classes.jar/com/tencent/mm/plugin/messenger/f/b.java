package com.tencent.mm.plugin.messenger.f;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class b
{
  public WeakReference<b> KRZ = null;
  
  public b(b paramb)
  {
    Assert.assertNotNull(paramb);
    this.KRZ = new WeakReference(paramb);
    ((e)h.ax(e.class)).a(gbt(), new e.c()
    {
      public final CharSequence a(Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(288608);
        String str = paramAnonymousBundle.getString("conv_talker_username", "");
        if (paramAnonymousMap == null)
        {
          Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non map!!");
          AppMethodBeat.o(288608);
          return null;
        }
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non header!!");
          AppMethodBeat.o(288608);
          return null;
        }
        if (Util.isNullOrNil(str))
        {
          Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: not resolved talker!!");
          AppMethodBeat.o(288608);
          return null;
        }
        paramAnonymousMap = b.this.b(paramAnonymousMap, paramAnonymousString, paramAnonymousBundle, paramAnonymousWeakReference, paramAnonymousWeakReference1);
        AppMethodBeat.o(288608);
        return paramAnonymousMap;
      }
    });
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    if ((this.KRZ != null) && (this.KRZ.get() != null)) {
      ((b)this.KRZ.get()).a(paramLong, paramLinkedList, paramInt);
    }
  }
  
  protected abstract CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  protected abstract String gbt();
  
  public void release()
  {
    ((e)h.ax(e.class)).aLc(gbt());
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
 * Qualified Name:     com.tencent.mm.plugin.messenger.f.b
 * JD-Core Version:    0.7.0.1
 */