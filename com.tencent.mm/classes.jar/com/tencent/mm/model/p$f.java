package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "GET_RECOMMEND_FEEDS_SCENE_PRELOAD", "GET_RECOMMEND_FEEDS_SCENE_ENTER", "GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", "GET_RECOMMEND_FEEDS_SCENE_REPLACE", "GET_RECOMMEND_FEEDS_SCENE_SUPPLEMENT", "GET_RECOMMEND_FEEDS_SCENE_REFRESH_AFTER_CLICK", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum p$f
{
  final int scene;
  
  static
  {
    AppMethodBeat.i(242037);
    ojt = new f("GET_RECOMMEND_FEEDS_SCENE_PRELOAD", 0, 1);
    oju = new f("GET_RECOMMEND_FEEDS_SCENE_ENTER", 1, 2);
    ojv = new f("GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", 2, 3);
    ojw = new f("GET_RECOMMEND_FEEDS_SCENE_REPLACE", 3, 4);
    ojx = new f("GET_RECOMMEND_FEEDS_SCENE_SUPPLEMENT", 4, 5);
    ojy = new f("GET_RECOMMEND_FEEDS_SCENE_REFRESH_AFTER_CLICK", 5, 6);
    ojz = new f[] { ojt, oju, ojv, ojw, ojx, ojy };
    AppMethodBeat.o(242037);
  }
  
  private p$f(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.p.f
 * JD-Core Version:    0.7.0.1
 */