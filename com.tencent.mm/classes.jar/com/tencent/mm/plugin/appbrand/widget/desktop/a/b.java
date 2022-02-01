package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.io.File;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b neo;
  
  static
  {
    AppMethodBeat.i(51420);
    neo = new b();
    AppMethodBeat.o(51420);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(51419);
    p.h(paramContext, "context");
    Object localObject = com.tencent.mm.dynamicbackground.a.b.gib;
    p.h(paramContext, "context");
    localObject = new File(com.tencent.mm.dynamicbackground.a.b.cl(paramContext));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "scene_shaderf.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "scene_shaderf.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "scene_shaderv.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "scene_shaderv.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "frag_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "frag_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "vertex_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "vertex_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "texture_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "texture_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "texture_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "texture_fragment_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "bg_gradient_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "bg_gradient_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "bg_gradient_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cl(paramContext) + "bg_gradient_fragment_shader.glsl");
    AppMethodBeat.o(51419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.b
 * JD-Core Version:    0.7.0.1
 */