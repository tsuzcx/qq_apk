package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.a.v;
import a.l;
import android.content.Intent;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "onResult"})
final class c$b$2
  implements e.a
{
  c$b$2(b paramb) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(143787);
    if ((paramIntent == null) || (paramInt == 0))
    {
      this.hEh.C(new Object[] { b.a.hQk });
      AppMethodBeat.o(143787);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (List)paramIntent.getStringArrayListExtra("key_select_video_list");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.BMx;
    }
    localArrayList.addAll((Collection)localObject1);
    localObject1 = (List)paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
    paramIntent = (Intent)localObject1;
    if (localObject1 == null) {
      paramIntent = (List)v.BMx;
    }
    localArrayList.addAll((Collection)paramIntent);
    paramIntent = this.hEh;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localArrayList).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new File((String)((Iterator)localObject2).next()));
    }
    paramIntent.C(new Object[] { new b.d((List)localObject1, 1) });
    AppMethodBeat.o(143787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.b.2
 * JD-Core Version:    0.7.0.1
 */