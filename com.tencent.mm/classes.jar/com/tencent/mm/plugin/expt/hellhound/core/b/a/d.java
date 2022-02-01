package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;

final class d
{
  final e szL;
  final com.tencent.mm.hellhoundlib.d szM;
  final b szN;
  
  d(e parame)
  {
    AppMethodBeat.i(121959);
    this.szM = new com.tencent.mm.hellhoundlib.d()
    {
      public final void a(Object paramAnonymousObject, Intent[] paramAnonymousArrayOfIntent)
      {
        AppMethodBeat.i(121949);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if ((d.this.szL != null) && (paramAnonymousArrayOfIntent != null) && (paramAnonymousArrayOfIntent.length > 0))
        {
          d.this.szL.a((Activity)paramAnonymousObject, paramAnonymousArrayOfIntent[0]);
          AppMethodBeat.o(121949);
          return;
        }
        AppMethodBeat.o(121949);
      }
      
      public final void b(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121948);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null)
        {
          if ((paramAnonymousObject instanceof Activity))
          {
            d.this.szL.a((Activity)paramAnonymousObject, paramAnonymousIntent);
            AppMethodBeat.o(121948);
            return;
          }
          d.this.szL.a(null, paramAnonymousIntent);
        }
        AppMethodBeat.o(121948);
      }
      
      public final void bf(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121952);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onCreate: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null)
        {
          paramAnonymousObject = (Activity)paramAnonymousObject;
          d.this.szL.d(paramAnonymousObject.getIntent(), paramAnonymousObject);
        }
        AppMethodBeat.o(121952);
      }
      
      public final void bg(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121954);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.Q((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121954);
      }
      
      public final void bh(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121955);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPostResume: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.R((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121955);
      }
      
      public final void bi(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121956);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPause: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null)
        {
          d.this.szL.S((Activity)paramAnonymousObject);
          d.this.szL.T((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121956);
      }
      
      public final void bj(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121957);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onStop: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.U((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121957);
      }
      
      public final void bk(Object paramAnonymousObject)
      {
        AppMethodBeat.i(121958);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onDestroy: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.V((Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121958);
      }
      
      public final void c(Object paramAnonymousObject, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(121953);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onNewIntent: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.e(paramAnonymousIntent, (Activity)paramAnonymousObject);
        }
        AppMethodBeat.o(121953);
      }
      
      public final void c(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121951);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, moveTaskToBack: %s, %d", new Object[] { paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.b((Activity)paramAnonymousObject, paramAnonymousBoolean);
        }
        AppMethodBeat.o(121951);
      }
      
      public final void x(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(121950);
        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, finish: %s, %d", new Object[] { paramAnonymousActivity.getClass().getName(), Integer.valueOf(paramAnonymousActivity.hashCode()) });
        if (d.this.szL != null) {
          d.this.szL.P(paramAnonymousActivity);
        }
        AppMethodBeat.o(121950);
      }
    };
    this.szN = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(220429);
        if ((paramAnonymousObject == null) || (paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length <= 0))
        {
          AppMethodBeat.o(220429);
          return;
        }
        if (((paramAnonymousObject instanceof Context)) && (!(paramAnonymousObject instanceof Activity))) {
          if ("startActivity".equals(paramAnonymousString4))
          {
            if ((d.this.szL != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent)))
            {
              Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.szL.a(null, (Intent)paramAnonymousArrayOfObject[0]);
              AppMethodBeat.o(220429);
            }
          }
          else if (("startActivities".equals(paramAnonymousString4)) && (d.this.szL != null) && ((paramAnonymousArrayOfObject[0] instanceof Intent[])))
          {
            paramAnonymousString3 = (Intent[])paramAnonymousArrayOfObject[0];
            if (paramAnonymousString3.length > 0)
            {
              Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %s, %s, %d, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousObject.getClass().getName(), Integer.valueOf(paramAnonymousObject.hashCode()), "from: mContextListener" });
              d.this.szL.a(null, paramAnonymousString3[0]);
            }
          }
        }
        AppMethodBeat.o(220429);
      }
    };
    this.szL = parame;
    AppMethodBeat.o(121959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.d
 * JD-Core Version:    0.7.0.1
 */