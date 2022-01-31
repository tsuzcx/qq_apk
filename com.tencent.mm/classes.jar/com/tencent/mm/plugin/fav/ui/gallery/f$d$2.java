package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f$d$2
  implements View.OnClickListener
{
  f$d$2(f.d paramd, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74570);
    Object localObject = this.mCF.mCs.wb(((Integer)paramView.getTag(2131820604)).intValue());
    if (localObject == null)
    {
      AppMethodBeat.o(74570);
      return;
    }
    paramView = this.mCF.mCs;
    Intent localIntent = new Intent();
    if (localObject == null)
    {
      ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
      AppMethodBeat.o(74570);
      return;
    }
    d locald = ((f.c)localObject).mCt;
    if (locald == null)
    {
      ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
      AppMethodBeat.o(74570);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramView.jfV.iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      long l = ((f.c)localIterator.next()).mCt.mCk.field_localId;
      if (localArrayList.contains(Long.valueOf(l))) {
        break label458;
      }
      localArrayList.add(Long.valueOf(l));
      if (l != ((f.c)localObject).mCt.mCk.field_localId) {
        break label458;
      }
    }
    label290:
    label301:
    label458:
    for (int i = localArrayList.size() - 1;; i = j)
    {
      j = i;
      break;
      localObject = new long[localArrayList.size()];
      if (j - 20 > 0)
      {
        i = j - 20;
        if (j + 20 >= localArrayList.size()) {
          break label290;
        }
        j += 20;
      }
      for (;;)
      {
        if (i >= j) {
          break label301;
        }
        localObject[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
        continue;
        i = 0;
        break;
        j = localArrayList.size();
      }
      localIntent.addFlags(536870912);
      localIntent.putExtra("KEY_MEDIA_FAVID_LIST", (long[])localObject).putExtra("key_detail_info_id", locald.mCk.field_localId).putExtra("key_detail_data_id", locald.cuZ.mBq);
      localIntent.putExtra("key_detail_fav_scene", paramView.mBU.scene);
      localIntent.putExtra("key_detail_fav_sub_scene", paramView.mBU.kbN);
      localIntent.putExtra("key_detail_fav_index", 0);
      localIntent.putExtra("key_detail_fav_query", paramView.mBU.query);
      localIntent.putExtra("key_detail_fav_sessionid", paramView.mBU.cpW);
      localIntent.putExtra("key_detail_fav_tags", paramView.mBU.mtm);
      b.b(paramView.mContext, ".ui.gallery.FavMediaGalleryUI", localIntent);
      ((Activity)paramView.mContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(74570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.2
 * JD-Core Version:    0.7.0.1
 */