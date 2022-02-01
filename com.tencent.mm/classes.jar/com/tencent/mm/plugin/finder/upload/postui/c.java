package com.tencent.mm.plugin.finder.upload.postui;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderJumperView;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.FinderJumpInfo;>;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderDefaultJumperWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "chooseView", "Lcom/tencent/mm/plugin/finder/view/FinderJumperView;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/view/FinderJumperView;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getChooseView", "()Lcom/tencent/mm/plugin/finder/view/FinderJumperView;", "curJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "jumpInfoList", "", "getPostData", "onCreate", "", "jumpInfo", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements j
{
  private final FinderJumperView Gfk;
  private FinderJumpInfo Gfp;
  private List<? extends FinderJumpInfo> Gfq;
  private final AppCompatActivity activity;
  
  public c(AppCompatActivity paramAppCompatActivity, FinderJumperView paramFinderJumperView)
  {
    AppMethodBeat.i(342848);
    this.activity = paramAppCompatActivity;
    this.Gfk = paramFinderJumperView;
    AppMethodBeat.o(342848);
  }
  
  public final List<FinderJumpInfo> feF()
  {
    return this.Gfq;
  }
  
  public final void hG(List<? extends FinderJumpInfo> paramList)
  {
    ImageView localImageView = null;
    AppMethodBeat.i(342858);
    this.Gfq = paramList;
    label39:
    Object localObject2;
    label90:
    Object localObject1;
    if (paramList == null)
    {
      paramList = null;
      this.Gfp = paramList;
      if (this.Gfp != null) {
        break label169;
      }
      this.Gfk.setVisibility(8);
      this.Gfk.setDefaultTitle("");
      this.Gfk.setDefaultIconId(0);
      this.Gfk.setFilledIconId(0);
      this.Gfk.setOnClickListener(null);
      localObject2 = this.Gfk;
      paramList = this.Gfp;
      if (paramList != null) {
        break label180;
      }
      paramList = "";
      FinderJumperView.a((FinderJumperView)localObject2, paramList);
      paramList = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      paramList = this.Gfp;
      if (paramList != null) {
        break label197;
      }
    }
    label169:
    label180:
    label197:
    for (paramList = localImageView;; paramList = paramList.icon_url)
    {
      paramList = new s(paramList, v.FKZ);
      localImageView = this.Gfk.getIconDefaultIv();
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(paramList, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExR));
      AppMethodBeat.o(342858);
      return;
      paramList = (FinderJumpInfo)kotlin.a.p.oL(paramList);
      break;
      this.Gfk.setVisibility(0);
      break label39;
      localObject1 = paramList.wording;
      paramList = (List<? extends FinderJumpInfo>)localObject1;
      if (localObject1 != null) {
        break label90;
      }
      paramList = "";
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.c
 * JD-Core Version:    0.7.0.1
 */