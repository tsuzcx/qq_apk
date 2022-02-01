package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.ae;

final class d
{
  final e qZu;
  final com.tencent.mm.hellhoundlib.d qZv;
  final b qZw;
  
  d(e parame)
  {
    AppMethodBeat.i(121959);
    this.qZv = new com.tencent.mm.hellhoundlib.d()
    {
      public final void a(Object paramAnonymousObject, Intent[] paramAnonymousArrayOfIntent)
      {
        AppMethodBeat.i(121949);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if ((d.this.qZu != null) && (paramAnonymousArrayOfIntent != null) && (paramAnonymousArrayOfIntent.length > 0))
        {
          d.this.qZu.a((Activity)paramAnonymousObject, paramAnonymousArrayOfIntent[0]);
          AppMethodBeat.o(121949);
          return;
        }
        AppMethodBeat.o(121949);
      }
      
      public final void aW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121952);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onCreate: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null)
        {
          paramAnonymousObject = (Activity)paramAnonymousObject;
          d.this.qZu.d(paramAnonymousObject.getIntent(), paramAnonymousObject);
        }
        AppMethodBeat.o(121952);
      }
      
      public final void aX(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121954);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.S((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121954);
      }
      
      public final void aY(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121955);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPostResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.T((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121955);
      }
      
      public final void aZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121956);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPause: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null)
        {
          d.this.qZu.U((Activity)paramAnonymousObject);
          d.this.qZu.V((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121956);
      }
      
      public final void b(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121948);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null)
        {
          if ((paramAnonymousObject instanceof Activity))
          {
            d.this.qZu.a((Activity)paramAnonymousObject, paramAnonymousIntent);
            AppMethodBeat.o(121948);
            return;
          }
          d.this.qZu.a(null, paramAnonymousIntent);
        }
        AppMethodBeat.o(121948);
      }
      
      public final void ba(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121957);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onStop: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.W((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121957);
      }
      
      public final void bb(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121958);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onDestroy: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.X((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121958);
      }
      
      public final void c(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121953);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onNewIntent: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.e(paramAnonymousIntent, (Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121953);
      }
      
      public final void d(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121951);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, moveTaskToBack: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.a((Activity)paramAnonymousObject, paramAnonymousBoolean);
        }
        AppMethodBeat.o(121951);
      }
      
      public final void x(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(121950);
        ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, finish: %s, %d", new Object[] { paramAnonymousActivity.getClass().getName(), Integer.valueOf(paramAnonymousActivity.hashCode()) });
        if (d.this.qZu != null) {
          d.this.qZu.R(paramAnonymousActivity);
        }
        AppMethodBeat.o(121950);
      }
    };
    this.qZw = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(195999);
        if ((paramAnonymousObject == null) || (paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length <= 0))
        {
          AppMethodBeat.o(195999);
          return;
        }
        if (((paramAnonymousObject instanceof Context)) && (!(paramAnonymousObject instanceof Activity))) {
          if ("startActivity".equals(paramAnonymousString4))
          {
            if ((d.this.qZu != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent)))
            {
              ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.qZu.a(null, (Intent)paramAnonymousArrayOfObject[0]);
              AppMethodBeat.o(195999);
            }
          }
          else if (("startActivities".equals(paramAnonymousString4)) && (d.this.qZu != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent[])))
          {
            paramAnonymousString3 = (Intent[])paramAnonymousArrayOfObject[0];
            if (paramAnonymousString3.length > 0)
            {
              ae.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.qZu.a(null, paramAnonymousString3[0]);
            }
          }
        }
        AppMethodBeat.o(195999);
      }
    };
    this.qZu = parame;
    AppMethodBeat.o(121959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.d
 * JD-Core Version:    0.7.0.1
 */