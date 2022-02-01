package com.tencent.mm.plugin.messenger.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts;
  String kgH;
  WeakReference<Context> lvU;
  long msgId;
  com.tencent.mm.plugin.messenger.b.a uHl;
  String uHm;
  String uHn;
  String uHo;
  String uHp;
  String uHq;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(198596);
    this.fts = null;
    com.tencent.mm.kernel.g.agi().a(3713, this);
    AppMethodBeat.o(198596);
  }
  
  static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(198599);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(198599);
    return paramArrayList;
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(198598);
    if (paramMap == null)
    {
      AppMethodBeat.o(198598);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bs.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(198593);
          a.this.msgId = paramBundle.getLong("msg_id");
          a locala = a.this;
          Map localMap = paramMap;
          String str1 = paramString;
          WeakReference localWeakReference = paramWeakReference;
          if (localWeakReference != null) {}
          ArrayList localArrayList;
          c.a locala1;
          do
          {
            try
            {
              if (localWeakReference.get() != null)
              {
                locala.lvU = localWeakReference;
                if ("new_tmpl_type_succeed_contact_window".equals((String)localMap.get(str1 + ".window_template.$type")))
                {
                  locala.uHm = bs.bG((String)localMap.get(str1 + ".window_template.title"), "");
                  locala.uHn = bs.bG((String)localMap.get(str1 + ".window_template.cancel_wording"), "");
                  locala.kgH = bs.bG((String)localMap.get(str1 + ".window_template.confirm_wording"), "");
                  locala.uHo = bs.bG((String)localMap.get(str1 + ".origin_username"), "");
                  locala.uHp = bs.bG((String)localMap.get(str1 + ".heir_username"), "");
                  locala.uHq = bs.bG((String)localMap.get(str1 + ".succeed_ticket"), "");
                  paramAnonymousView = c.alO(locala.uHm);
                  if ((paramAnonymousView == null) || (paramAnonymousView.size() <= 0)) {
                    break label711;
                  }
                  localArrayList = new ArrayList();
                  Iterator localIterator = paramAnonymousView.iterator();
                  for (;;)
                  {
                    if (!localIterator.hasNext()) {
                      break label697;
                    }
                    locala1 = (c.a)localIterator.next();
                    if ((locala1 != null) && (locala1.content != null))
                    {
                      if (locala1.type != 0) {
                        break;
                      }
                      localArrayList.add(new SpannableString(k.c(ai.getContext(), locala1.content)));
                    }
                  }
                }
              }
              ((f)com.tencent.mm.kernel.g.ab(f.class)).a("new_link_succeed_contact", paramMap, paramBundle);
            }
            catch (Exception paramAnonymousView)
            {
              ac.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
            }
            AppMethodBeat.o(198593);
            return;
          } while (locala1.type != 1);
          int i = 0;
          for (;;)
          {
            paramAnonymousView = str1 + ".window_template.link_list.link";
            if (i != 0) {
              paramAnonymousView = paramAnonymousView + i;
            }
            for (;;)
            {
              if (bs.isNullOrNil((String)localMap.get(paramAnonymousView))) {
                break label763;
              }
              String str2 = (String)localMap.get(paramAnonymousView + ".$name");
              String str3 = (String)localMap.get(paramAnonymousView + ".$type");
              if ((!locala1.content.equals(str2)) || (!"link_plain".equals(str3))) {
                break label765;
              }
              localArrayList.add(bs.bG((String)localMap.get(paramAnonymousView + ".plain"), ""));
              break label765;
              label697:
              locala.uHm = a.concactSpannable(localArrayList).toString();
              label711:
              locala.uHl = new com.tencent.mm.plugin.messenger.b.a(locala.uHo, locala.uHp, locala.uHq, 1);
              com.tencent.mm.kernel.g.agi().a(locala.uHl, 0);
              locala.fF((Context)localWeakReference.get());
              break;
            }
            label763:
            break;
            label765:
            i += 1;
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(198598);
      return localSpannableString;
    }
  }
  
  public final String dcL()
  {
    return "new_link_succeed_contact";
  }
  
  final void fF(Context paramContext)
  {
    AppMethodBeat.i(198600);
    if (this.fts == null)
    {
      paramContext.getString(2131755906);
      this.fts = h.b(paramContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(198594);
          com.tencent.mm.kernel.g.agi().a(a.this.uHl);
          AppMethodBeat.o(198594);
        }
      });
      AppMethodBeat.o(198600);
      return;
    }
    if (!this.fts.isShowing()) {
      this.fts.show();
    }
    AppMethodBeat.o(198600);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(198601);
    ac.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.fts != null) && (this.fts.isShowing())) {
      this.fts.dismiss();
    }
    if ((paramn instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(ai.getContext()).aRQ(ai.getContext().getString(2131766240)).acQ(2131766205).b(null).show();
        com.tencent.mm.plugin.messenger.e.a.N(this.msgId, 7);
        AppMethodBeat.o(198601);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramn;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).uHk == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).uHk)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramn).action;
          if (localObject == null) {
            break;
          }
          ac.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((bye)localObject).BaseResponse.Ret), Integer.valueOf(paramInt1) });
          if (paramInt1 == 1)
          {
            paramString = new f.a((Context)this.lvU.get());
            paramString.yi(false);
            paramString.aRQ(this.uHm).aRV(this.uHn).aRU(this.kgH).c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(198595);
                ac.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                if (paramAnonymousBoolean)
                {
                  if ((a.this.lvU == null) || (a.this.lvU.get() == null))
                  {
                    ac.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                    AppMethodBeat.o(198595);
                    return;
                  }
                  paramAnonymousString = (Context)a.this.lvU.get();
                  a.this.uHl = new com.tencent.mm.plugin.messenger.b.a(a.this.uHo, a.this.uHp, a.this.uHq, 2);
                  com.tencent.mm.kernel.g.agi().a(a.this.uHl, 0);
                  a.this.fF(paramAnonymousString);
                  com.tencent.mm.plugin.messenger.e.a.N(a.this.msgId, 9);
                  AppMethodBeat.o(198595);
                  return;
                }
                com.tencent.mm.plugin.messenger.e.a.N(a.this.msgId, 10);
                AppMethodBeat.o(198595);
              }
            }).show();
            com.tencent.mm.plugin.messenger.e.a.N(this.msgId, 8);
          }
          AppMethodBeat.o(198601);
          return;
        }
        ac.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = ai.getContext();
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = ai.getContext().getString(2131755733);
      }
      t.makeText((Context)localObject, paramn, 0).show();
      com.tencent.mm.plugin.messenger.e.a.N(this.msgId, 6);
    }
    AppMethodBeat.o(198601);
  }
  
  public final void release()
  {
    AppMethodBeat.i(198597);
    super.release();
    com.tencent.mm.kernel.g.agi().b(3713, this);
    AppMethodBeat.o(198597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */