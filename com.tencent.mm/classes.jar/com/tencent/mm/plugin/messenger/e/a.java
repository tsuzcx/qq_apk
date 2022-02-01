package com.tencent.mm.plugin.messenger.e;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements e
{
  private Map<String, LinkedList<e.c>> EWe;
  private Map<String, LinkedList<e.a>> EWf;
  private Map<String, HashSet<e.d>> EWg;
  private LinkedList<e.b> EWh;
  private com.tencent.mm.ay.a.d.a<Long, CharSequence> EWi;
  private com.tencent.mm.ay.a.d.a<Long, CharSequence> EWj;
  public t EWk;
  
  public a()
  {
    AppMethodBeat.i(90754);
    this.EWe = new HashMap();
    this.EWf = new HashMap();
    this.EWg = new HashMap();
    this.EWh = new LinkedList();
    this.EWi = new com.tencent.mm.ay.a.d.a(200);
    this.EWj = new com.tencent.mm.ay.a.d.a(500);
    this.EWk = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(90750);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[] { paramAnonymousMap.toString() });
        a.a(a.this, paramAnonymousString, paramAnonymousMap, paramAnonymousa);
        AppMethodBeat.o(90750);
      }
    };
    AppMethodBeat.o(90754);
  }
  
  private static CharSequence I(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(90767);
    if (Util.getInt((String)paramMap.get(paramString + ".$hidden"), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
      paramString = new SpannableString("");
      AppMethodBeat.o(90767);
      return paramString;
    }
    paramString = (String)paramMap.get(paramString + ".plain");
    paramString = new SpannableString(l.c(MMApplicationContext.getContext(), Util.nullAsNil(paramString)));
    AppMethodBeat.o(90767);
    return paramString;
  }
  
  private CharSequence a(Map<String, String> paramMap, Bundle paramBundle, WeakReference<Context> paramWeakReference, int paramInt, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(212921);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Object localObject2 = new StringBuilder();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "";
      label35:
      localObject1 = localObject1;
      localObject1 = ".sysmsg.sysmsgtemplate.content_template" + (String)localObject1;
      if (paramMap.get(localObject1) == null) {
        break label949;
      }
      localObject2 = (String)paramMap.get((String)localObject1 + ".$type");
      if (!aPl((String)localObject2))
      {
        Log.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[] { localObject2 });
        localArrayList1.add(I((String)localObject1, paramMap));
      }
      if (paramBundle != null) {
        paramBundle.putString("template_type", (String)localObject2);
      }
      localObject1 = (String)paramMap.get((String)localObject1 + ".template");
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[] { localObject1 });
      localObject1 = c.aPn((String)localObject1);
      if (localObject1 != null) {
        break label287;
      }
    }
    label287:
    for (int j = 0;; j = ((ArrayList)localObject1).size())
    {
      Log.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", new Object[] { Integer.valueOf(j) });
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label297;
      }
      localArrayList1.add(new SpannableString(""));
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label35;
    }
    label297:
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    label313:
    c.a locala;
    if (localIterator.hasNext())
    {
      locala = (c.a)localIterator.next();
      if (locala.type == 0)
      {
        localObject2 = this.EWh.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (e.b)((Iterator)localObject2).next();
        } while (!((e.b)localObject1).al(paramMap).booleanValue());
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localArrayList2.add(((e.b)localObject1).m(paramMap, locala.content));
        break label313;
      }
      localArrayList2.add(new SpannableString(l.c(MMApplicationContext.getContext(), locala.content)));
      break label313;
      if (locala.type == 1)
      {
        j = 0;
        localObject2 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
        localObject1 = localObject2;
        if (j != 0) {
          localObject1 = (String)localObject2 + j;
        }
        if ((String)paramMap.get(localObject1) == null) {
          break label313;
        }
        localObject2 = (String)paramMap.get((String)localObject1 + ".$name");
        String str;
        label635:
        boolean bool;
        if (locala.content.equals(localObject2))
        {
          str = (String)paramMap.get((String)localObject1 + ".$type");
          if (paramInt != 0) {
            break label777;
          }
          localObject2 = (List)this.EWe.get(str);
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            break label711;
          }
          localObject2 = null;
          if ((aPm(str)) && (localObject2 != null)) {
            break label742;
          }
          str = Util.nullAs(str, "");
          if (localObject2 != null) {
            break label736;
          }
          bool = true;
          label665:
          Log.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", new Object[] { str, Boolean.valueOf(bool) });
          localArrayList2.add(I((String)localObject1, paramMap));
        }
        for (;;)
        {
          j += 1;
          break;
          label711:
          localObject2 = (e.c)((LinkedList)this.EWe.get(str)).getLast();
          break label635;
          label736:
          bool = false;
          break label665;
          label742:
          localObject1 = ((e.c)localObject2).a(paramMap, (String)localObject1, paramBundle, paramWeakReference, paramWeakReference1);
          ae((CharSequence)localObject1);
          localArrayList2.add(nullAsNil((CharSequence)localObject1));
          continue;
          label777:
          if (paramInt == 1)
          {
            localObject2 = (List)this.EWf.get(str);
            if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {}
            for (localObject2 = null;; localObject2 = (e.a)((LinkedList)this.EWf.get(str)).getLast())
            {
              if ((aPm(str)) && (localObject2 != null)) {
                break label870;
              }
              localArrayList2.add(I((String)localObject1, paramMap));
              break;
            }
            label870:
            localArrayList2.add(Util.nullAsNil(((e.a)localObject2).f(paramMap, (String)localObject1)));
          }
          else
          {
            Log.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
          }
        }
      }
      Log.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
      break label313;
      localObject1 = concactSpannable(localArrayList2);
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[] { localObject1 });
      localArrayList1.add(localObject1);
      break;
      label949:
      if (localArrayList1.size() == 0)
      {
        Log.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
        paramMap = new SpannableString("");
        AppMethodBeat.o(212921);
        return paramMap;
      }
      paramMap = concactSpannable(localArrayList1);
      AppMethodBeat.o(212921);
      return paramMap;
      localObject1 = null;
    }
  }
  
  private static boolean aPl(String paramString)
  {
    AppMethodBeat.i(90768);
    if (("tmpl_type_profile".equals(paramString)) || ("tmpl_type_profilewithrevoke".equals(paramString)) || ("tmpl_type_profilewithrevokeqrcode".equals(paramString)) || ("tmpl_type_wxappnotifywithview".equals(paramString)) || ("tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_jump_chat".equals(paramString)) || ("tmpl_type_gamelife_link_url".equals(paramString)) || ("tmpl_type_gamelife_plain".equals(paramString)) || ("new_tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_profilewithrevokeandunbindapp".equals(paramString)))
    {
      AppMethodBeat.o(90768);
      return true;
    }
    AppMethodBeat.o(90768);
    return false;
  }
  
  private static boolean aPm(String paramString)
  {
    AppMethodBeat.i(90769);
    if (("link_profile".equals(paramString)) || ("link_revoke".equals(paramString)) || ("link_revoke_qrcode".equals(paramString)) || ("link_plain".equals(paramString)) || ("link_view_wxapp".equals(paramString)) || ("link_succeed_contact".equals(paramString)) || ("link_jump_chat".equals(paramString)) || ("link_admin_explain".equals(paramString)) || ("new_link_succeed_contact".equals(paramString)) || ("link_live".equals(paramString)) || ("link_url".equals(paramString)) || ("comment_link_profile".equals(paramString)) || ("link_revoke_unbindapp".equals(paramString)) || ("link_history".equals(paramString)))
    {
      AppMethodBeat.o(90769);
      return true;
    }
    AppMethodBeat.o(90769);
    return false;
  }
  
  private static void ae(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(90765);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && ((paramCharSequence instanceof Spanned)))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        int j = paramCharSequence.length;
        while (i < j)
        {
          if (!(paramCharSequence[i] instanceof com.tencent.mm.ui.base.span.a))
          {
            paramCharSequence = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
            AppMethodBeat.o(90765);
            throw paramCharSequence;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(90765);
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(90766);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(90766);
    return paramArrayList;
  }
  
  private static CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(90764);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(90764);
      return paramCharSequence;
    }
    AppMethodBeat.o(90764);
    return paramCharSequence;
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(212910);
    if (!this.EWh.contains(paramb)) {
      this.EWh.add(paramb);
    }
    AppMethodBeat.o(212910);
  }
  
  public final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(90759);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[] { paramString });
    if (!this.EWf.containsKey(paramString)) {
      this.EWf.put(paramString, new LinkedList());
    }
    if (!((List)this.EWf.get(paramString)).contains(parama)) {
      ((LinkedList)this.EWf.get(paramString)).add(parama);
    }
    AppMethodBeat.o(90759);
  }
  
  public final void a(String paramString, e.c paramc)
  {
    AppMethodBeat.i(212897);
    if (!this.EWe.containsKey(paramString)) {
      this.EWe.put(paramString, new LinkedList());
    }
    List localList = (List)this.EWe.get(paramString);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s list=%s", new Object[] { paramString, localList });
    if ((localList != null) && (!localList.contains(paramc))) {
      ((LinkedList)this.EWe.get(paramString)).add(paramc);
    }
    AppMethodBeat.o(212897);
  }
  
  public final void a(final String paramString, final e.d paramd)
  {
    AppMethodBeat.i(212891);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90751);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", new Object[] { paramString });
        HashSet localHashSet2 = (HashSet)a.a(a.this).get(paramString);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null) {
          localHashSet1 = new HashSet();
        }
        if (!localHashSet1.contains(paramd)) {
          localHashSet1.add(paramd);
        }
        a.a(a.this).put(paramString, localHashSet1);
        AppMethodBeat.o(90751);
      }
    });
    AppMethodBeat.o(212891);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(212907);
    try
    {
      Object localObject = paramBundle.getString("template_type");
      localObject = (HashSet)this.EWg.get(localObject);
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.d)((Iterator)localObject).next()).b(paramString, paramMap, paramBundle);
        }
      }
      AppMethodBeat.o(212907);
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SysMsgTemplateImp", paramString, "", new Object[0]);
      AppMethodBeat.o(212907);
      return;
    }
  }
  
  public final void aOe(String paramString)
  {
    AppMethodBeat.i(212898);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[] { paramString });
    if (!this.EWe.containsKey(paramString)) {
      Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.EWe.get(paramString);
    if (localLinkedList == null)
    {
      Log.e("MicroMsg.SysMsgTemplateImp", "list is null!");
      AppMethodBeat.o(212898);
      return;
    }
    Log.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(212898);
  }
  
  public final void aOf(String paramString)
  {
    AppMethodBeat.i(90760);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[] { paramString });
    if (!this.EWf.containsKey(paramString)) {
      Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.EWf.get(paramString);
    Log.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(90760);
  }
  
  public final CharSequence aOg(String paramString)
  {
    AppMethodBeat.i(90762);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      Log.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
      AppMethodBeat.o(90762);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((Util.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = a(paramString, null, null, 1, null);
    AppMethodBeat.o(90762);
    return paramString;
  }
  
  public final CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(212903);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
      AppMethodBeat.o(212903);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      Log.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
      AppMethodBeat.o(212903);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((Util.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(212903);
      return null;
    }
    paramString = a(paramString, paramBundle, paramWeakReference, 0, paramWeakReference1);
    AppMethodBeat.o(212903);
    return paramString;
  }
  
  public final void b(e.b paramb)
  {
    AppMethodBeat.i(212914);
    this.EWh.remove(paramb);
    AppMethodBeat.o(212914);
  }
  
  public final void b(final String paramString, final e.d paramd)
  {
    AppMethodBeat.i(212895);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90752);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", new Object[] { paramString });
        HashSet localHashSet = (HashSet)a.a(a.this).get(paramString);
        if (localHashSet == null)
        {
          AppMethodBeat.o(90752);
          return;
        }
        localHashSet.remove(paramd);
        if (localHashSet.size() == 0)
        {
          a.a(a.this).remove(paramString);
          AppMethodBeat.o(90752);
          return;
        }
        a.a(a.this).put(paramString, localHashSet);
        AppMethodBeat.o(90752);
      }
    });
    AppMethodBeat.o(212895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */