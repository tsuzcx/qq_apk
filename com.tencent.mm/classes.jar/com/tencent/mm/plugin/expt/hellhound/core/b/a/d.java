package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.ad;

final class d
{
  final e pEJ;
  final com.tencent.mm.hellhoundlib.d pEK;
  final b pEL;
  
  d(e parame)
  {
    AppMethodBeat.i(121959);
    this.pEK = new com.tencent.mm.hellhoundlib.d()
    {
      public final void a(Object paramAnonymousObject, Intent[] paramAnonymousArrayOfIntent)
      {
        AppMethodBeat.i(121949);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if ((d.this.pEJ != null) && (paramAnonymousArrayOfIntent != null) && (paramAnonymousArrayOfIntent.length > 0))
        {
          d.this.pEJ.a((Activity)paramAnonymousObject, paramAnonymousArrayOfIntent[0]);
          AppMethodBeat.o(121949);
          return;
        }
        AppMethodBeat.o(121949);
      }
      
      public final void aX(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121952);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onCreate: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null)
        {
          paramAnonymousObject = (Activity)paramAnonymousObject;
          d.this.pEJ.d(paramAnonymousObject.getIntent(), paramAnonymousObject);
        }
        AppMethodBeat.o(121952);
      }
      
      public final void aY(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121954);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.Q((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121954);
      }
      
      public final void aZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121955);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPostResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.R((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121955);
      }
      
      public final void b(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121948);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null)
        {
          if ((paramAnonymousObject instanceof Activity))
          {
            d.this.pEJ.a((Activity)paramAnonymousObject, paramAnonymousIntent);
            AppMethodBeat.o(121948);
            return;
          }
          d.this.pEJ.a(null, paramAnonymousIntent);
        }
        AppMethodBeat.o(121948);
      }
      
      public final void ba(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121956);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPause: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null)
        {
          d.this.pEJ.S((Activity)paramAnonymousObject);
          d.this.pEJ.T((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121956);
      }
      
      public final void bb(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121957);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onStop: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.U((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121957);
      }
      
      public final void bc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121958);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onDestroy: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.V((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121958);
      }
      
      public final void c(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121953);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onNewIntent: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.e(paramAnonymousIntent, (Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121953);
      }
      
      public final void c(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121951);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, moveTaskToBack: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.a((Activity)paramAnonymousObject, paramAnonymousBoolean);
        }
        AppMethodBeat.o(121951);
      }
      
      public final void x(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(121950);
        ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, finish: %s, %d", new Object[] { paramAnonymousActivity.getClass().getName(), Integer.valueOf(paramAnonymousActivity.hashCode()) });
        if (d.this.pEJ != null) {
          d.this.pEJ.P(paramAnonymousActivity);
        }
        AppMethodBeat.o(121950);
      }
    };
    this.pEL = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(177360);
        if ((paramAnonymousObject == null) || (paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length <= 0))
        {
          AppMethodBeat.o(177360);
          return;
        }
        if (((paramAnonymousObject instanceof Context)) && (!(paramAnonymousObject instanceof Activity))) {
          if ("startActivity".equals(paramAnonymousString3))
          {
            if ((d.this.pEJ != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent)))
            {
              ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.pEJ.a(null, (Intent)paramAnonymousArrayOfObject[0]);
              AppMethodBeat.o(177360);
            }
          }
          else if (("startActivities".equals(paramAnonymousString3)) && (d.this.pEJ != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent[])))
          {
            paramAnonymousString3 = (Intent[])paramAnonymousArrayOfObject[0];
            if (paramAnonymousString3.length > 0)
            {
              ad.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.pEJ.a(null, paramAnonymousString3[0]);
            }
          }
        }
        AppMethodBeat.o(177360);
      }
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
    };
    this.pEJ = parame;
    AppMethodBeat.o(121959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.d
 * JD-Core Version:    0.7.0.1
 */