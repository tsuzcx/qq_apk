package com.tencent.mm.plugin.ac;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmDBAnno;", "", "entities", "", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "()[Ljava/lang/Class;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public @interface e
{
  Class<? extends IAutoDBItem>[] gsA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.e
 * JD-Core Version:    0.7.0.1
 */