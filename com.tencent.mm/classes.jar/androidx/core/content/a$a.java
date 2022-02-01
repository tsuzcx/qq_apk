package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
{
  static void a(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(195538);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "androidx/core/content/ContextCompat$Api16Impl", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0), (Bundle)paramIntent.sb(1));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat$Api16Impl", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(195538);
  }
  
  static void a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(195521);
    paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(paramArrayOfIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfIntent.aYi(), "androidx/core/content/ContextCompat$Api16Impl", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
    paramContext.startActivities((Intent[])paramArrayOfIntent.sb(0), (Bundle)paramArrayOfIntent.sb(1));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat$Api16Impl", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(195521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.content.a.a
 * JD-Core Version:    0.7.0.1
 */