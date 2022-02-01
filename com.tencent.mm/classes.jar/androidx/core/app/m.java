package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class m
  implements Iterable<Intent>
{
  private final ArrayList<Intent> bpV;
  private final Context bpW;
  
  private m(Context paramContext)
  {
    AppMethodBeat.i(196367);
    this.bpV = new ArrayList();
    this.bpW = paramContext;
    AppMethodBeat.o(196367);
  }
  
  public static m Z(Context paramContext)
  {
    AppMethodBeat.i(196375);
    paramContext = new m(paramContext);
    AppMethodBeat.o(196375);
    return paramContext;
  }
  
  private m b(ComponentName paramComponentName)
  {
    AppMethodBeat.i(196387);
    int i = this.bpV.size();
    try
    {
      for (paramComponentName = d.a(this.bpW, paramComponentName); paramComponentName != null; paramComponentName = d.a(this.bpW, paramComponentName.getComponent())) {
        this.bpV.add(i, paramComponentName);
      }
      AppMethodBeat.o(196387);
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      paramComponentName = new IllegalArgumentException(paramComponentName);
      AppMethodBeat.o(196387);
      throw paramComponentName;
    }
    return this;
  }
  
  public final void DD()
  {
    AppMethodBeat.i(196422);
    if (this.bpV.isEmpty())
    {
      localObject1 = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
      AppMethodBeat.o(196422);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = (Intent[])this.bpV.toArray(new Intent[this.bpV.size()]);
    localObject1[0] = new Intent(localObject1[0]).addFlags(268484608);
    if (!androidx.core.content.a.a(this.bpW, (Intent[])localObject1))
    {
      Object localObject2 = new Intent(localObject1[(localObject1.length - 1)]);
      ((Intent)localObject2).addFlags(268435456);
      localObject1 = this.bpW;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "androidx/core/app/TaskStackBuilder", "startActivities", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "androidx/core/app/TaskStackBuilder", "startActivities", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(196422);
  }
  
  public final m i(Activity paramActivity)
  {
    AppMethodBeat.i(196399);
    Object localObject = ((a)paramActivity).getSupportParentActivityIntent();
    if (localObject == null) {}
    for (paramActivity = d.f(paramActivity);; paramActivity = (Activity)localObject)
    {
      if (paramActivity != null)
      {
        ComponentName localComponentName = paramActivity.getComponent();
        localObject = localComponentName;
        if (localComponentName == null) {
          localObject = paramActivity.resolveActivity(this.bpW.getPackageManager());
        }
        b((ComponentName)localObject);
        this.bpV.add(paramActivity);
      }
      AppMethodBeat.o(196399);
      return this;
    }
  }
  
  @Deprecated
  public final Iterator<Intent> iterator()
  {
    AppMethodBeat.i(196414);
    Iterator localIterator = this.bpV.iterator();
    AppMethodBeat.o(196414);
    return localIterator;
  }
  
  public static abstract interface a
  {
    public abstract Intent getSupportParentActivityIntent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.m
 * JD-Core Version:    0.7.0.1
 */