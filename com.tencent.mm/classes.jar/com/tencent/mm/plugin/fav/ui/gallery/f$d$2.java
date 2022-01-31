package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f$d$2
  implements View.OnClickListener
{
  f$d$2(f.d paramd, f paramf) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = this.khY.khK.rf(((Integer)paramView.getTag(n.e.fav_filter_data_pos)).intValue());
    if (localObject == null) {
      return;
    }
    paramView = this.khY.khK;
    Intent localIntent = new Intent();
    if (localObject == null)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
      return;
    }
    d locald = ((f.c)localObject).khL;
    if (locald == null)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramView.heL.iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      long l = ((f.c)localIterator.next()).khL.khA.field_localId;
      if (localArrayList.contains(Long.valueOf(l))) {
        break label434;
      }
      localArrayList.add(Long.valueOf(l));
      if (l != ((f.c)localObject).khL.khA.field_localId) {
        break label434;
      }
    }
    label271:
    label282:
    label434:
    for (int i = localArrayList.size() - 1;; i = j)
    {
      j = i;
      break;
      localObject = new long[localArrayList.size()];
      if (j - 20 > 0)
      {
        i = j - 20;
        if (j + 20 >= localArrayList.size()) {
          break label271;
        }
        j += 20;
      }
      for (;;)
      {
        if (i >= j) {
          break label282;
        }
        localObject[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
        continue;
        i = 0;
        break;
        j = localArrayList.size();
      }
      localIntent.addFlags(536870912);
      localIntent.putExtra("KEY_MEDIA_FAVID_LIST", (long[])localObject).putExtra("key_detail_info_id", locald.khA.field_localId).putExtra("key_detail_data_id", locald.bNH.kgC);
      localIntent.putExtra("key_detail_fav_scene", paramView.khf.scene);
      localIntent.putExtra("key_detail_fav_sub_scene", paramView.khf.jYS);
      localIntent.putExtra("key_detail_fav_index", 0);
      localIntent.putExtra("key_detail_fav_query", paramView.khf.bVk);
      localIntent.putExtra("key_detail_fav_sessionid", paramView.khf.bIB);
      localIntent.putExtra("key_detail_fav_tags", paramView.khf.jYU);
      b.a(paramView.mContext, ".ui.gallery.FavMediaGalleryUI", localIntent);
      ((Activity)paramView.mContext).overridePendingTransition(0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.2
 * JD-Core Version:    0.7.0.1
 */