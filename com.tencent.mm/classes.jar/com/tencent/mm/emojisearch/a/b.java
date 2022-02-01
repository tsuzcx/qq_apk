package com.tencent.mm.emojisearch.a;

import com.tencent.mm.ak.i;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "", "getEmojiSearchList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onCrate", "onDestroy", "plugin-emojisdk_release"})
public abstract interface b
{
  public abstract void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, i parami);
  
  public abstract void awy();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emojisearch.a.b
 * JD-Core Version:    0.7.0.1
 */